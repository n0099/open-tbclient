package com.baidu.browser.webkit;

import android.os.Handler;
import android.os.Message;
import com.baidu.browser.core.net.BdNet;
import com.baidu.browser.core.net.BdNetListener;
import com.baidu.browser.core.net.BdNetTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.loginshare.e;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BdWapEngine implements BdNetListener {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdWapEngine";
    private static final int MSG_LOAD_WAP_URL = 1;
    private static final int MSG_UNLOAD_WAP_URL = 2;
    public static final String TRANSCODE_URL = "http://gate.baidu.com/tc?w2x=1&src=";
    private BdNet mNet;
    private Handler mPrivateHandler = new Handler() { // from class: com.baidu.browser.webkit.BdWapEngine.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    BdWapEngine.this.mWapClient.onLoadWapUrl((String) message.obj);
                    return;
                case 2:
                    BdWapEngine.this.mWapClient.onUnloadWapUrl((String) message.obj);
                    return;
                default:
                    BdWapEngine.this.mWapClient.onUnloadWapUrl((String) message.obj);
                    return;
            }
        }
    };
    private BdWapClient mWapClient;
    private static final String[] ARRAY_WHITE_LIST = {"3g.joyes.com", "d.cn", "wap2.joyes.com"};
    private static final String[] ARRAY_BLACK_LIST = {"m.baidu.com"};

    public BdWapEngine(BdWapClient bdWapClient) {
        this.mWapClient = bdWapClient;
    }

    public static boolean checkWapUrl(String str) {
        if (str == null) {
            return false;
        }
        int length = ARRAY_BLACK_LIST.length;
        for (int i = 0; i < length; i++) {
            if (str.contains(ARRAY_BLACK_LIST[i])) {
                return false;
            }
        }
        if (Pattern.compile("(^(http://wap\\.|http://3g\\.|http://m\\.))|((\\.wml)$)").matcher(str).find()) {
            return true;
        }
        return Pattern.compile("(\\.cn/?)$").matcher(str).find() && !Pattern.compile("(\\.com.cn/?)$").matcher(str).find();
    }

    public static String getSrcUrl(String str) {
        int indexOf = str.indexOf("src=");
        if (indexOf < 0) {
            return null;
        }
        String substring = str.substring("src=".length() + indexOf, str.length());
        if (substring != null && substring.length() > 0) {
            try {
                String decode = URLDecoder.decode(substring, BdUtil.UTF8);
                if (!decode.startsWith(e.f) && !decode.startsWith(e.g)) {
                    return e.f + decode;
                }
                return decode;
            } catch (UnsupportedEncodingException e) {
            }
        }
        return null;
    }

    public void loadUrl(String str) {
        if (this.mNet == null) {
            this.mNet = new BdNet();
            this.mNet.setEventListener(this);
        }
        this.mNet.obtainTask(str).start();
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        boolean z = false;
        String url = bdNetTask.getUrl();
        String headerField = bdNetTask.getConnection().getHeaderField("Content-Type");
        if (headerField != null) {
            if (headerField.indexOf("vnd.wap.wml") > 0) {
                z = true;
            } else {
                int length = ARRAY_WHITE_LIST.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (url.contains(ARRAY_WHITE_LIST[i])) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (z) {
                if (!url.startsWith(TRANSCODE_URL)) {
                    try {
                        url = TRANSCODE_URL + URLEncoder.encode(url, BdUtil.UTF8);
                    } catch (UnsupportedEncodingException e) {
                    }
                }
                this.mPrivateHandler.obtainMessage(1, url).sendToTarget();
                return;
            }
            this.mPrivateHandler.obtainMessage(2, url).sendToTarget();
        }
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        this.mPrivateHandler.obtainMessage(2, bdNetTask.getUrl()).sendToTarget();
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }
}
