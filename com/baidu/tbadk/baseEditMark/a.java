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
    private boolean AM;
    private c AF = null;
    private d AG = null;
    private b AH = null;
    private int AJ = 0;
    private int AL = 0;
    protected BaseActivity.LoadDataCallBack AN = null;
    private ArrayList<MarkData> AI = new ArrayList<>();

    public a() {
        this.AM = false;
        this.AM = true;
    }

    public int getOffset() {
        if (this.AI == null) {
            return 0;
        }
        return this.AI.size();
    }

    public int kW() {
        return this.AL;
    }

    public void aM(int i) {
        this.AL = i;
    }

    public boolean hasMore() {
        return this.AJ >= 20;
    }

    public void reset() {
        this.AL = 0;
        this.AJ = 0;
        this.AM = true;
    }

    public boolean isFirst() {
        return this.AM;
    }

    public ArrayList<MarkData> kX() {
        return this.AI;
    }

    public void k(ArrayList<MarkData> arrayList) {
        this.AI = arrayList;
    }

    public void l(ArrayList<MarkData> arrayList) {
        if (this.AI != null && arrayList != null) {
            this.AI.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void a(MarkData markData) {
        this.AI.add(markData);
    }

    public int getCount() {
        if (this.AI == null) {
            return 0;
        }
        return this.AI.size();
    }

    public int kY() {
        return this.AJ;
    }

    public void kZ() {
        ArrayList<MarkData> aio = j.aio();
        if (aio != null) {
            k(aio);
        }
    }

    public String m(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.AI == null) {
            return null;
        }
        if (i >= this.AI.size()) {
            i2 -= (i - this.AI.size()) - 1;
            i = this.AI.size() - 1;
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
                    JSONObject json = this.AI.get(i5).toJson();
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

    public void bx(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> by(String str) {
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
                    this.AI.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void c(Boolean bool) {
        if (this.AF != null) {
            this.AF.cancel();
        }
        this.AF = new c(this, getOffset());
        this.AF.setPriority(3);
        this.AF.execute(bool);
    }

    public void startSync() {
        if (this.AG != null) {
            this.AG.cancel();
        }
        this.AG = new d(this, null);
        this.AG.setPriority(2);
        this.AG.execute(new a[0]);
    }

    public boolean aN(int i) {
        if (this.AH != null) {
            this.AH.cancel();
        }
        if (i >= this.AI.size() || this.AI.get(i) == null || this.AI.get(i).getId() == null) {
            return false;
        }
        this.AH = new b(this, this.AI.get(i).getId(), i);
        this.AH.setPriority(2);
        this.AH.execute(new Boolean[0]);
        return true;
    }

    public int la() {
        return com.baidu.tbadk.core.sharedPref.b.oc().getInt("uploac_mark_offset", 399);
    }

    public void aO(int i) {
        com.baidu.tbadk.core.sharedPref.b.oc().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.AF != null) {
            this.AF.cancel();
        }
        if (this.AG != null) {
            this.AG.cancel();
        }
        if (this.AH != null) {
            this.AH.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.AN = loadDataCallBack;
    }

    private void removalDuplicate() {
        if (this.AI != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.AI.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
