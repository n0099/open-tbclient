package com.baidu.live.an;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.PopupWindow;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class a {
    public ab alaLiveShowData;
    public String anchorPortrait;
    private CustomMessageListener bWl;
    private CustomMessageListener bWm;
    public long bWn;
    public String bWo;
    public long liveId;
    private Activity mContext;
    public boolean isHost = false;
    private h bWa = new h() { // from class: com.baidu.live.an.a.2
        @Override // com.baidu.live.view.web.h
        public boolean iz(String str) {
            if (!TextUtils.isEmpty(str)) {
                return a.this.iD(str);
            }
            return false;
        }
    };
    private List<d> bWk = new ArrayList();

    public a(Activity activity) {
        this.mContext = activity;
        XZ();
        Ya();
    }

    public void a(c cVar) {
        a(cVar, (b) null);
    }

    public void a(c cVar, final b bVar) {
        if (this.mContext != null && !this.mContext.isFinishing()) {
            if ((Build.VERSION.SDK_INT < 17 || !this.mContext.isDestroyed()) && cVar != null && !TextUtils.isEmpty(cVar.url)) {
                String str = cVar.url;
                iC(str);
                final d dVar = new d(this.mContext);
                dVar.getWebView().setBackgroundColor(iE(str));
                dVar.bWy = iF(str);
                g gVar = new g();
                gVar.t(this.mContext).a(dVar).a(dVar.getWebView().getSchemeCallback()).b(this.bWa);
                gVar.a(cVar.bWu);
                gVar.bF(this.liveId);
                gVar.bE(this.bWn);
                gVar.iy(this.bWo);
                gVar.dH(this.isHost);
                com.baidu.live.view.web.a[] XY = gVar.XY();
                for (com.baidu.live.view.web.a aVar : XY) {
                    dVar.getWebView().addJavascriptInterface(aVar, aVar.getName());
                }
                this.bWk.add(dVar);
                dVar.b(cVar, bVar);
                dVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.an.a.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (dVar != null) {
                            a.this.bWk.remove(dVar);
                        }
                        if (bVar != null) {
                            bVar.onDismiss();
                        }
                    }
                });
            }
        }
    }

    private boolean iB(String str) {
        return str != null && str.contains("show_last_live_room_btn=1");
    }

    private void iC(String str) {
        if (str != null && str.contains("close_last_pop=1")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
        }
    }

    public void resume() {
        for (d dVar : this.bWk) {
            if (dVar != null && dVar.isShowing() && dVar.getWebView() != null) {
                dVar.getWebView().onResume();
            }
        }
    }

    public void pause() {
        for (d dVar : this.bWk) {
            if (dVar != null && dVar.isShowing() && dVar.getWebView() != null) {
                dVar.getWebView().onPause();
            }
        }
    }

    public void dismiss() {
        for (d dVar : this.bWk) {
            if (dVar != null) {
                dVar.Yc();
            }
        }
    }

    public void cr(int i) {
        for (d dVar : this.bWk) {
            if (dVar != null && dVar.isShowing()) {
                dVar.cr(i);
            }
        }
    }

    public void Fy() {
        dismiss();
    }

    public void release() {
        Fy();
        MessageManager.getInstance().unRegisterListener(this.bWl);
        this.bWl = null;
        MessageManager.getInstance().unRegisterListener(this.bWm);
        this.bWm = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iD(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.equals(HttpHost.DEFAULT_SCHEME_NAME, scheme) || "https".equals(scheme)) {
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                    map = null;
                } else {
                    Map<String, String> iG = iG(str);
                    if (iG.isEmpty()) {
                        map = iG;
                    } else {
                        queryParameterNames = iG.keySet();
                        map = iG;
                    }
                }
                c cVar = new c();
                if (queryParameterNames != null) {
                    if (queryParameterNames.contains("fullscreen")) {
                        String queryParameter = parse.getQueryParameter("fullscreen");
                        if (queryParameter == null && map != null) {
                            queryParameter = map.get("fullscreen");
                        }
                        cVar.isFullScreen = TextUtils.equals(queryParameter, "1");
                    } else if (queryParameterNames.contains(UbcStatConstant.KEY_CONTENT_ROOM)) {
                        String queryParameter2 = parse.getQueryParameter(UbcStatConstant.KEY_CONTENT_ROOM);
                        if (queryParameter2 == null && map != null) {
                            queryParameter2 = map.get(UbcStatConstant.KEY_CONTENT_ROOM);
                        }
                        if (TextUtils.equals("1", queryParameter2)) {
                            cVar.isFullScreen = false;
                        } else {
                            BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), str);
                            return true;
                        }
                    }
                }
                if (iB(str) && this.alaLiveShowData != null && this.alaLiveShowData != null && this.alaLiveShowData.mLiveInfo != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    alaLastLiveroomInfo.setLastLiveId(this.alaLiveShowData.mLiveInfo.live_id);
                    alaLastLiveroomInfo.setLastAnchorUname(this.alaLiveShowData.mLiveInfo.getNameShow());
                    alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.alaLiveShowData.mLiveInfo.user_id));
                    alaLastLiveroomInfo.setLastAnchorPortrait(this.alaLiveShowData.aIU.cover);
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
                    alaLastLiveroomInfo.setIsAudio(1);
                    cVar.bWu = alaLastLiveroomInfo;
                }
                cVar.url = str;
                a(cVar);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void XZ() {
        if (this.bWl == null) {
            this.bWl = new CustomMessageListener(2913123) { // from class: com.baidu.live.an.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    for (d dVar : a.this.bWk) {
                        if (dVar != null && dVar.isShowing()) {
                            dVar.dismiss();
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bWl);
        }
    }

    private void Ya() {
        if (this.bWm == null) {
            this.bWm = new CustomMessageListener(2913303) { // from class: com.baidu.live.an.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        if (a.this.bWk != null && a.this.bWk.size() != 0) {
                            String str = (String) customResponsedMessage.getData();
                            if (!TextUtils.isEmpty(str)) {
                                for (d dVar : a.this.bWk) {
                                    if (dVar != null && dVar.Yd() != null) {
                                        if (!(!dVar.isShowing())) {
                                            String str2 = dVar.Yd().url;
                                            if ((!TextUtils.isEmpty(str2)) && str.contains(str2)) {
                                                dVar.dismiss();
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    BdLog.d("StandardWebController close target webview error");
                }
            };
            MessageManager.getInstance().registerListener(this.bWm);
        }
    }

    private int iE(String str) {
        Map<String, String> iG;
        String str2 = null;
        try {
            str2 = Uri.parse(str).getQueryParameter("background");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if ((TextUtils.isEmpty(str2) || str2.length() != 8) && (iG = iG(str)) != null && iG.containsKey("background")) {
            str2 = iG.get("background");
        }
        if (TextUtils.isEmpty(str2) || str2.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(str2.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + str2.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean iF(String str) {
        Map<String, String> iG;
        String str2 = null;
        try {
            str2 = Uri.parse(str).getQueryParameter("noloading");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(str2) && (iG = iG(str)) != null && iG.containsKey("noloading")) {
            str2 = iG.get("noloading");
        }
        return TextUtils.equals(str2, "1");
    }

    private Map<String, String> iG(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (str.indexOf("?") > 0) {
                String[] split = str.split("\\?");
                if (split.length >= 2) {
                    String[] split2 = split[1].split(ETAG.ITEM_SEPARATOR);
                    if (split2.length > 0) {
                        for (String str2 : split2) {
                            if (!TextUtils.isEmpty(str2)) {
                                String[] split3 = str2.split("=");
                                if (split3.length >= 2) {
                                    hashMap.put(split3[0], split3[1]);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
