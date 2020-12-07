package com.baidu.live.ag.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.d;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements a {
    private Handler mHandler;

    @Override // com.baidu.live.ag.a.a
    public boolean a(long j, Object obj) {
        DownloadData downloadData;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return false;
        }
        if (obj == null) {
            downloadData = null;
        } else {
            downloadData = (DownloadData) obj;
        }
        long j2 = (downloadData == null || !downloadData.isForceDownload()) ? j : j - 10485760;
        long Sp = Sp();
        if (Sp <= j2) {
            return true;
        }
        Log.i("StorageOptOperationImpl", "check_maxLength:" + j2);
        Log.i("StorageOptOperationImpl", "check_cleanableLength:" + Sp);
        List<DownloadData> taskList = FileSerialDownLoader.getInstance().getTaskList();
        if (taskList != null && !taskList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (DownloadData downloadData2 : taskList) {
                if (downloadData2.getType() == 19 || downloadData2.getType() == 20) {
                    arrayList.add(downloadData2);
                }
            }
            a(j, Sp, (DownloadData[]) arrayList.toArray(new DownloadData[arrayList.size()]));
            arrayList.clear();
        }
        FileSerialDownLoader.getInstance().cancelDownloadByType(19, false);
        FileSerialDownLoader.getInstance().cancelDownloadByType(20, false);
        if (downloadData != null && !downloadData.isForceDownload()) {
            a(j, Sp, downloadData);
            return false;
        }
        a(downloadData == null, j2, Sp, Sq(), Sr());
        long Sp2 = Sp();
        Log.i("StorageOptOperationImpl", "complete_cleanableLength:" + Sp2);
        return downloadData == null || (downloadData.isForceDownload() && Sp2 < j2);
    }

    @Override // com.baidu.live.ag.a.a
    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private long Sp() {
        return FileHelper.getFileLength(new File(com.baidu.live.ag.b.Sb()));
    }

    private void a(boolean z, long j, long j2, List<u> list, List<com.baidu.live.entereffect.a.a> list2) {
        if (list != null && !list.isEmpty()) {
            String str = list.remove(0).name;
            if (!TextUtils.isEmpty(str)) {
                FileHelper.deleteFileOrDir(new File(com.baidu.live.ag.b.iy(str)));
                ac.hy(str);
                v.he(str);
                Log.i("StorageOptOperationImpl", "clean_gift:" + str);
                a(z, j, j2, "", str);
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            String str2 = list2.remove(0).id;
            if (!TextUtils.isEmpty(str2)) {
                FileHelper.deleteFileOrDir(new File(com.baidu.live.ag.b.iC(str2)));
                com.baidu.live.entereffect.a.Gi().gM(str2);
                Log.i("StorageOptOperationImpl", "clean_enter:" + str2);
                a(z, j, j2, str2, "");
            }
        }
        if ((list != null && !list.isEmpty()) || (list2 != null && !list2.isEmpty())) {
            long Sp = Sp();
            if (Sp > j) {
                a(z, j, Sp, list, list2);
            }
        }
    }

    private List<u> Sq() {
        JSONArray jSONArray;
        String string = d.BM().getString("gift_dynamic_res_last_accessed", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(string);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null) {
            int i = 0;
            ArrayList<u> arrayList = null;
            while (i < jSONArray.length()) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.add(new u().D(jSONArray.optJSONObject(i)));
                i++;
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                Collections.sort(arrayList, new Comparator<u>() { // from class: com.baidu.live.ag.a.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(u uVar, u uVar2) {
                        if (uVar.aUE < uVar2.aUE) {
                            return -1;
                        }
                        return uVar.aUE == uVar2.aUE ? 0 : 1;
                    }
                });
                JSONArray jSONArray2 = new JSONArray();
                for (u uVar : arrayList) {
                    jSONArray2.put(uVar.toJsonObject());
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private List<com.baidu.live.entereffect.a.a> Sr() {
        List<com.baidu.live.entereffect.a.a> Gj = com.baidu.live.entereffect.a.Gi().Gj();
        if (Gj == null) {
            return null;
        }
        ArrayList<com.baidu.live.entereffect.a.a> arrayList = new ArrayList(Gj);
        Collections.sort(arrayList, new Comparator<com.baidu.live.entereffect.a.a>() { // from class: com.baidu.live.ag.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(com.baidu.live.entereffect.a.a aVar, com.baidu.live.entereffect.a.a aVar2) {
                if (aVar.aUE < aVar2.aUE) {
                    return -1;
                }
                return aVar.aUE == aVar2.aUE ? 0 : 1;
            }
        });
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar : arrayList) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", aVar.id);
                jSONObject.put("last_accessed", aVar.aUE);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private void a(final long j, final long j2, final DownloadData... downloadDataArr) {
        if (downloadDataArr != null && downloadDataArr.length != 0) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.live.ag.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    DownloadData[] downloadDataArr2;
                    com.baidu.live.gift.c hx;
                    for (DownloadData downloadData : downloadDataArr) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("cartoon_id", downloadData.getId());
                            jSONObject.put("quota", j);
                            jSONObject.put("space_ocp", j2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String str = "portrait";
                        if (downloadData.getType() == 19 && (hx = ac.hx(downloadData.getName())) != null && hx.aVv != null && hx.aVv.aVt != null && hx.aVv.aVt.isLandScape()) {
                            str = "landscape";
                        }
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "cartoon_limit").setContentExt(null, null, str, jSONObject));
                    }
                }
            });
        }
    }

    private void a(final boolean z, final long j, final long j2, final String str, final String str2) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.live.ag.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.gift.b bVar;
                String str3 = str;
                String str4 = "portrait";
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.live.gift.c hx = ac.hx(str2);
                    if (hx != null && (bVar = hx.aVv) != null) {
                        str3 = bVar.giftId;
                        if (bVar.aVt != null && bVar.aVt.isLandScape()) {
                            str4 = "landscape";
                        }
                    } else {
                        return;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cartoon_id", str3);
                    jSONObject.put("quota", j);
                    jSONObject.put("space_ocp", j2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "cartoon_delete").setContentExt(z ? "quota" : "space", null, str4, jSONObject));
            }
        });
    }
}
