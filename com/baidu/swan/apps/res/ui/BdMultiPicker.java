package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.tieba.rm1;
import com.baidu.tieba.t43;
import com.baidu.tieba.xj3;
import com.baidu.tieba.y43;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BdMultiPicker extends LinearLayout {
    public static final boolean l = rm1.a;
    public LinearLayout a;
    public JSONArray b;
    public JSONArray c;
    public int d;
    public b e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public y43 k;

    /* loaded from: classes4.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    /* loaded from: classes4.dex */
    public class a implements y43 {
        public a() {
        }

        @Override // com.baidu.tieba.y43
        public void a(WheelView3d wheelView3d, int i) {
            int currentItem = wheelView3d.getCurrentItem();
            int intValue = ((Integer) wheelView3d.getTag()).intValue();
            if (!BdMultiPicker.this.h(intValue, currentItem)) {
                if (BdMultiPicker.l) {
                    Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                }
            } else if (BdMultiPicker.this.e != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(CriusAttrConstants.COLUMN, intValue);
                    jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, currentItem);
                } catch (JSONException e) {
                    if (BdMultiPicker.l) {
                        e.printStackTrace();
                    }
                }
                if (BdMultiPicker.l) {
                    Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                }
                BdMultiPicker.this.e.a(BdMultiPicker.this, jSONObject);
            }
        }
    }

    public JSONArray getCurrentIndex() {
        if (l && this.c != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.c.toString());
        }
        return this.c;
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = 0;
        this.g = 16;
        this.j = 15;
        this.k = new a();
        d(context);
    }

    public final void d(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00c5, this);
        this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092a89);
        this.g = xj3.f(context, this.g);
        this.j = xj3.f(context, this.j);
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.b = jSONArray;
            this.d = jSONArray.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.c = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        this.e = bVar;
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = 0;
        this.g = 16;
        this.j = 15;
        this.k = new a();
        d(context);
    }

    public final void f(WheelView3d wheelView3d, int i) {
        if (this.d < 2) {
            return;
        }
        if (i == 0) {
            wheelView3d.setGravityOffset(-this.j);
        }
        if (i == this.d - 1) {
            wheelView3d.setGravityOffset(this.j);
        }
    }

    public final boolean g(int i, JSONArray jSONArray) {
        JSONArray jSONArray2 = this.b;
        if (jSONArray2 != null && i >= 0 && i <= jSONArray2.length() - 1) {
            try {
                this.b.put(i, jSONArray);
                return true;
            } catch (JSONException e) {
                if (l) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public final boolean h(int i, int i2) {
        JSONArray jSONArray = this.c;
        if (jSONArray != null && i >= 0 && i <= jSONArray.length() - 1) {
            try {
                if (this.c.getInt(i) != i2) {
                    this.c.put(i, i2);
                    return true;
                }
            } catch (JSONException e) {
                if (l) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = 0;
        this.g = 16;
        this.j = 15;
        this.k = new a();
        d(context);
    }

    public void j(int i, JSONArray jSONArray, int i2) {
        g(i, jSONArray);
        h(i, i2);
        k(i, jSONArray, i2);
    }

    public final void e(Context context) {
        this.h = xj3.f(context, 16.0f);
        this.i = xj3.f(context, 14.0f);
        for (int i = 0; i < this.d; i++) {
            WheelView3d wheelView3d = new WheelView3d(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            wheelView3d.setOnItemSelectedListener(this.k);
            wheelView3d.setTag(Integer.valueOf(i));
            wheelView3d.setCyclic(false);
            wheelView3d.setCenterTextSize(this.h);
            wheelView3d.setOuterTextSize(this.i);
            wheelView3d.setDividerType(WheelView3d.DividerType.FILL);
            wheelView3d.setDividerColor(0);
            wheelView3d.setGravity(17);
            wheelView3d.setTextColorCenter(-16777216);
            wheelView3d.setTextColorOut(-16777216);
            wheelView3d.setLineSpacingMultiplier(3.0f);
            wheelView3d.setVisibleItem(7);
            f(wheelView3d, i);
            this.a.addView(wheelView3d, layoutParams);
        }
        this.f = true;
    }

    public void i() {
        if (this.d == 0) {
            return;
        }
        if (!this.f) {
            e(getContext());
        }
        for (int i = 0; i < this.d; i++) {
            JSONArray optJSONArray = this.b.optJSONArray(i);
            ArrayList arrayList = null;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList2.add(optString);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayList.add("");
            }
            WheelView3d wheelView3d = (WheelView3d) this.a.getChildAt(i);
            wheelView3d.setAdapter(new t43(arrayList));
            wheelView3d.setCurrentItem(this.c.optInt(i));
            wheelView3d.setCyclic(false);
        }
    }

    public final void k(int i, JSONArray jSONArray, int i2) {
        WheelView3d wheelView3d = (WheelView3d) this.a.getChildAt(i);
        if (wheelView3d != null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(jSONArray.optString(i3));
                }
            } else {
                arrayList.add("");
            }
            if (l) {
                Log.d("BdMultiPicker", "update wheel UI dataArray : " + jSONArray);
            }
            wheelView3d.setCyclic(false);
            wheelView3d.setAdapter(new t43(arrayList));
            wheelView3d.setCurrentItem(i2);
        }
    }

    public void setMultiWheelData(JSONArray jSONArray, JSONArray jSONArray2) {
        if (l) {
            if (jSONArray != null) {
                Log.i("BdMultiPicker", "setMultiWheelData: dataArray=" + jSONArray.toString());
            }
            if (jSONArray2 != null) {
                Log.i("BdMultiPicker", "setMultiWheelData: dataIndex=" + jSONArray2.toString());
            }
        }
        setDataArray(jSONArray);
        setDataIndex(jSONArray2);
        i();
    }
}
