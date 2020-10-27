package com.baidu.live.ab;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.d;
import com.baidu.live.gift.ab;
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
public class c {
    private boolean bjT;
    private Handler mHandler;
    private long mQuota;

    /* loaded from: classes4.dex */
    public interface a {
        void Qb();
    }

    public static c PX() {
        return b.btc;
    }

    public void cx(boolean z) {
        this.bjT = com.baidu.live.z.a.Pq().bmJ != null && com.baidu.live.z.a.Pq().bmJ.aMz && z;
        a(null);
    }

    public synchronized boolean b(DownloadData downloadData) {
        boolean z = false;
        synchronized (this) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (!this.bjT || this.mQuota <= 0) {
                    z = true;
                } else {
                    long j = this.mQuota;
                    long j2 = (downloadData == null || !downloadData.isForceDownload()) ? j : j - 10485760;
                    long PY = PY();
                    if (PY <= j2) {
                        z = true;
                    } else {
                        Log.i("StorageOptManager", "check_maxLength:" + j2);
                        Log.i("StorageOptManager", "check_cleanableLength:" + PY);
                        List<DownloadData> taskList = FileSerialDownLoader.getInstance().getTaskList();
                        if (taskList != null && !taskList.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            for (DownloadData downloadData2 : taskList) {
                                if (downloadData2.getType() == 19 || downloadData2.getType() == 20) {
                                    arrayList.add(downloadData2);
                                }
                            }
                            a(this.mQuota, PY, (DownloadData[]) arrayList.toArray(new DownloadData[arrayList.size()]));
                            arrayList.clear();
                        }
                        FileSerialDownLoader.getInstance().cancelDownloadByType(19, false);
                        FileSerialDownLoader.getInstance().cancelDownloadByType(20, false);
                        if (downloadData != null && !downloadData.isForceDownload()) {
                            a(this.mQuota, PY, downloadData);
                        } else {
                            a(downloadData == null, j2, PY, PZ(), Qa());
                            long PY2 = PY();
                            Log.i("StorageOptManager", "complete_cleanableLength:" + PY2);
                            z = downloadData == null || (downloadData.isForceDownload() && PY2 < j2);
                        }
                    }
                }
            }
        }
        return z;
    }

    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mQuota = 0L;
        this.bjT = false;
    }

    private long PY() {
        return FileHelper.getFileLength(new File(com.baidu.live.ab.b.PQ()));
    }

    private void a(final a aVar) {
        if (!this.bjT || this.mQuota <= 0) {
            if (aVar != null) {
                aVar.Qb();
                return;
            }
            return;
        }
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.live.ab.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(c.this.b(null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                super.onPostExecute((AnonymousClass1) bool);
                if (aVar != null) {
                    aVar.Qb();
                }
            }
        }.execute(new Void[0]);
    }

    private void a(boolean z, long j, long j2, List<u> list, List<com.baidu.live.entereffect.a.a> list2) {
        if (list != null && !list.isEmpty()) {
            String str = list.remove(0).name;
            if (!TextUtils.isEmpty(str)) {
                FileHelper.deleteFileOrDir(new File(com.baidu.live.ab.b.hT(str)));
                v.gK(str);
                Log.i("StorageOptManager", "clean_gift:" + str);
                a(z, j, j2, "", str);
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            String str2 = list2.remove(0).id;
            if (!TextUtils.isEmpty(str2)) {
                FileHelper.deleteFileOrDir(new File(com.baidu.live.ab.b.hX(str2)));
                com.baidu.live.entereffect.a.EF().gr(str2);
                Log.i("StorageOptManager", "clean_enter:" + str2);
                a(z, j, j2, str2, "");
            }
        }
        if ((list != null && !list.isEmpty()) || (list2 != null && !list2.isEmpty())) {
            long PY = PY();
            if (PY > j) {
                a(z, j, PY, list, list2);
            }
        }
    }

    private List<u> PZ() {
        JSONArray jSONArray;
        String string = d.AZ().getString("gift_dynamic_res_last_accessed", "");
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
                arrayList2.add(new u().G(jSONArray.optJSONObject(i)));
                i++;
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                Collections.sort(arrayList, new Comparator<u>() { // from class: com.baidu.live.ab.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(u uVar, u uVar2) {
                        if (uVar.aRV < uVar2.aRV) {
                            return -1;
                        }
                        return uVar.aRV == uVar2.aRV ? 0 : 1;
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

    private List<com.baidu.live.entereffect.a.a> Qa() {
        List<com.baidu.live.entereffect.a.a> EG = com.baidu.live.entereffect.a.EF().EG();
        if (EG == null) {
            return null;
        }
        ArrayList<com.baidu.live.entereffect.a.a> arrayList = new ArrayList(EG);
        Collections.sort(arrayList, new Comparator<com.baidu.live.entereffect.a.a>() { // from class: com.baidu.live.ab.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(com.baidu.live.entereffect.a.a aVar, com.baidu.live.entereffect.a.a aVar2) {
                if (aVar.aRV < aVar2.aRV) {
                    return -1;
                }
                return aVar.aRV == aVar2.aRV ? 0 : 1;
            }
        });
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar : arrayList) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", aVar.id);
                jSONObject.put("last_accessed", aVar.aRV);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        private static c btc = new c();
    }

    public void a(final long j, final long j2, final DownloadData... downloadDataArr) {
        if (downloadDataArr != null && downloadDataArr.length != 0) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.live.ab.c.4
                @Override // java.lang.Runnable
                public void run() {
                    DownloadData[] downloadDataArr2;
                    com.baidu.live.gift.c hc;
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
                        if (downloadData.getType() == 19 && (hc = ab.hc(downloadData.getName())) != null && hc.aSL != null && hc.aSL.aSJ != null && hc.aSL.aSJ.isLandScape()) {
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
        this.mHandler.post(new Runnable() { // from class: com.baidu.live.ab.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.gift.b bVar;
                String str3 = str;
                String str4 = "portrait";
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.live.gift.c hc = ab.hc(str2);
                    if (hc != null && (bVar = hc.aSL) != null) {
                        str3 = bVar.giftId;
                        if (bVar.aSJ != null && bVar.aSJ.isLandScape()) {
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
