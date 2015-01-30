package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.util.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean AP;
    private c AI = null;
    private d AJ = null;
    private b AL = null;
    private int AN = 0;
    private int AO = 0;
    protected BaseActivity.LoadDataCallBack AQ = null;
    private ArrayList<MarkData> AM = new ArrayList<>();

    public a() {
        this.AP = false;
        this.AP = true;
    }

    public int getOffset() {
        if (this.AM == null) {
            return 0;
        }
        return this.AM.size();
    }

    public int ld() {
        return this.AO;
    }

    public void aM(int i) {
        this.AO = i;
    }

    public boolean hasMore() {
        return this.AN >= 20;
    }

    public void reset() {
        this.AO = 0;
        this.AN = 0;
        this.AP = true;
    }

    public boolean isFirst() {
        return this.AP;
    }

    public ArrayList<MarkData> le() {
        return this.AM;
    }

    public void k(ArrayList<MarkData> arrayList) {
        this.AM = arrayList;
    }

    public void l(ArrayList<MarkData> arrayList) {
        if (this.AM != null && arrayList != null) {
            this.AM.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void a(MarkData markData) {
        this.AM.add(markData);
    }

    public int getCount() {
        if (this.AM == null) {
            return 0;
        }
        return this.AM.size();
    }

    public int lf() {
        return this.AN;
    }

    public void lg() {
        ArrayList<MarkData> ait = j.ait();
        if (ait != null) {
            k(ait);
        }
    }

    public String m(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.AM == null) {
            return null;
        }
        if (i >= this.AM.size()) {
            i2 -= (i - this.AM.size()) - 1;
            i = this.AM.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (true) {
            if (i5 < 0) {
                jSONArray = jSONArray2;
                break;
            } else if (i5 <= i - i2) {
                jSONArray = jSONArray2;
                break;
            } else {
                try {
                    JSONObject json = this.AM.get(i5).toJson();
                    if (json == null || i4 < 0) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        jSONArray2.put(i4, json);
                    }
                    i5--;
                    i4 = i3;
                } catch (Exception e) {
                    BdLog.e(e.toString());
                    jSONArray = null;
                }
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void bA(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> bB(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
            for (int i = 0; i < optJSONArray.length(); i++) {
                MarkData markData = new MarkData();
                markData.paserJson(optJSONArray.getJSONObject(i));
                arrayList.add(markData);
            }
            return arrayList;
        }
        return null;
    }

    public void paserJson(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.AM.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void c(Boolean bool) {
        if (this.AI != null) {
            this.AI.cancel();
        }
        this.AI = new c(this, getOffset());
        this.AI.setPriority(3);
        this.AI.execute(bool);
    }

    public void startSync() {
        if (this.AJ != null) {
            this.AJ.cancel();
        }
        this.AJ = new d(this, null);
        this.AJ.setPriority(2);
        this.AJ.execute(new a[0]);
    }

    public boolean aN(int i) {
        if (this.AL != null) {
            this.AL.cancel();
        }
        if (i >= this.AM.size() || this.AM.get(i) == null || this.AM.get(i).getId() == null) {
            return false;
        }
        this.AL = new b(this, this.AM.get(i).getId(), i);
        this.AL.setPriority(2);
        this.AL.execute(new Boolean[0]);
        return true;
    }

    public int lh() {
        return com.baidu.tbadk.core.sharedPref.b.oj().getInt("uploac_mark_offset", 399);
    }

    public void aO(int i) {
        com.baidu.tbadk.core.sharedPref.b.oj().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.AI != null) {
            this.AI.cancel();
        }
        if (this.AJ != null) {
            this.AJ.cancel();
        }
        if (this.AL != null) {
            this.AL.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.AQ = loadDataCallBack;
    }

    private void removalDuplicate() {
        if (this.AM != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.AM.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
