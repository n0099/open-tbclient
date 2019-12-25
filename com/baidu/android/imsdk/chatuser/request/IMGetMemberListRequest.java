package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMGetMemberListRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    private static final int MAX_BUID_TO_NICK_COUNT = 200;
    public static final String TAG = "IMGetMemberListRequest";
    public static ConcurrentHashMap<String, String> buid2NickMap = new ConcurrentHashMap<>();
    private List<String> mBuids = new ArrayList();
    private Context mContext;
    private Map<String, Long> mMap;
    private boolean mUpdate;

    public IMGetMemberListRequest(Context context, Map<String, Long> map, boolean z) {
        this.mContext = context;
        this.mMap = map;
        this.mBuids.addAll(map.keySet());
        this.mUpdate = z;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        StringBuilder sb = new StringBuilder("https://mbd.baidu.com/userbox?action=group&model=user_list");
        sb.append("&osbranch=a0");
        sb.append("&osname=baiduboxapp");
        sb.append("&ua=").append(getUA(this.mContext));
        return sb.toString();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<String> it = this.mBuids.iterator();
        while (it.hasNext()) {
            sb.append("\"" + SocialEncodeUtils.getSocialEncryption(it.next(), "baiduuid_") + "\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("uks=").append(URLEncoder.encode(sb.toString()));
        sb2.append("&puid=").append(URLEncoder.encode(SocialEncodeUtils.getSocialEncryption(AccountManagerImpl.getInstance(this.mContext).getUid(), "baiduuid_")));
        return sb2.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        JSONArray jSONArray;
        String str;
        String str2;
        if (i == 200) {
            try {
                ArrayList<ChatSession> arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (jSONObject.getInt("errno") == 0) {
                    if (this.mUpdate) {
                        Utility.setLastUpdateNickNameTime(this.mContext, System.currentTimeMillis());
                    }
                    if (jSONObject.has("data") && (jSONArray = jSONObject.getJSONArray("data")) != null && jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            if (!jSONObject2.has("uk")) {
                                str = "";
                            } else {
                                str = SocialEncodeUtils.getSocialDecrypt(jSONObject2.getString("uk"), "baiduuid_");
                            }
                            if (!jSONObject2.has("display_name")) {
                                str2 = "";
                            } else {
                                str2 = jSONObject2.getString("display_name");
                            }
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                ChatSession chatSession = new ChatSession(0, this.mMap.get(str).longValue(), Long.parseLong(str), "");
                                chatSession.setNickName(str2);
                                arrayList.add(chatSession);
                            }
                        }
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        for (ChatSession chatSession2 : arrayList) {
                            if (ChatMessageDBManager.getInstance(this.mContext).updateChatSessionNickName(chatSession2) <= 0 && !buid2NickMap.keySet().contains(chatSession2.getContacterId() + "")) {
                                if (buid2NickMap.size() >= 200) {
                                    buid2NickMap.clear();
                                }
                                buid2NickMap.put(chatSession2.getContacterId() + "", chatSession2.getNickName());
                            } else {
                                return;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "IMGetMemberListRequest onSuccess Exception " + e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "  errorCode: " + i + "resultContent = " + new String(bArr));
    }

    private String getUA(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.densityDpi;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(i2);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(PraiseDataPassUtil.KEY_FROM_OS);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(AccountManagerImpl.getInstance(this.mContext).getAppVersion());
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(i3);
        return stringBuffer.toString();
    }
}
