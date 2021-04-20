package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BdMultiPicker extends LinearLayout {
    public static final boolean p = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f12091e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f12092f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f12093g;

    /* renamed from: h  reason: collision with root package name */
    public int f12094h;
    public b i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public d.b.g0.a.q1.a.f.c.b o;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.q1.a.f.c.b {
        public a() {
        }

        @Override // d.b.g0.a.q1.a.f.c.b
        public void a(WheelView3d wheelView3d, int i) {
            int currentItem = wheelView3d.getCurrentItem();
            int intValue = ((Integer) wheelView3d.getTag()).intValue();
            if (!BdMultiPicker.this.h(intValue, currentItem)) {
                if (BdMultiPicker.p) {
                    Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                }
            } else if (BdMultiPicker.this.i != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("column", intValue);
                    jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, currentItem);
                } catch (JSONException e2) {
                    if (BdMultiPicker.p) {
                        e2.printStackTrace();
                    }
                }
                if (BdMultiPicker.p) {
                    Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                }
                BdMultiPicker.this.i.a(BdMultiPicker.this, jSONObject);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.f12092f = new JSONArray();
        this.f12093g = new JSONArray();
        this.f12094h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a();
        d(context);
    }

    public final void d(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(g.aiapps_multipicker_layout, this);
        this.f12091e = (LinearLayout) findViewById(f.wheel_container);
        this.k = h0.e(context, this.k);
        this.n = h0.e(context, this.n);
    }

    public final void e(Context context) {
        this.l = h0.e(context, 16.0f);
        this.m = h0.e(context, 14.0f);
        for (int i = 0; i < this.f12094h; i++) {
            WheelView3d wheelView3d = new WheelView3d(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            wheelView3d.setOnItemSelectedListener(this.o);
            wheelView3d.setTag(Integer.valueOf(i));
            wheelView3d.setCyclic(true);
            wheelView3d.setCenterTextSize(this.l);
            wheelView3d.setOuterTextSize(this.m);
            wheelView3d.setDividerType(WheelView3d.DividerType.FILL);
            wheelView3d.setDividerColor(0);
            wheelView3d.setGravity(17);
            wheelView3d.setTextColorCenter(-16777216);
            wheelView3d.setTextColorOut(-16777216);
            wheelView3d.setLineSpacingMultiplier(3.0f);
            wheelView3d.setVisibleItem(7);
            f(wheelView3d, i);
            this.f12091e.addView(wheelView3d, layoutParams);
        }
        this.j = true;
    }

    public final void f(WheelView3d wheelView3d, int i) {
        if (this.f12094h < 2) {
            return;
        }
        if (i == 0) {
            wheelView3d.setGravityOffset(-this.n);
        }
        if (i == this.f12094h - 1) {
            wheelView3d.setGravityOffset(this.n);
        }
    }

    public final boolean g(int i, JSONArray jSONArray) {
        JSONArray jSONArray2 = this.f12092f;
        if (jSONArray2 != null && i >= 0 && i <= jSONArray2.length() - 1) {
            try {
                this.f12092f.put(i, jSONArray);
                return true;
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public JSONArray getCurrentIndex() {
        if (p && this.f12093g != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.f12093g.toString());
        }
        return this.f12093g;
    }

    public final boolean h(int i, int i2) {
        JSONArray jSONArray = this.f12093g;
        if (jSONArray != null && i >= 0 && i <= jSONArray.length() - 1) {
            try {
                if (this.f12093g.getInt(i) != i2) {
                    this.f12093g.put(i, i2);
                    return true;
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void i() {
        if (this.f12094h == 0) {
            return;
        }
        if (!this.j) {
            e(getContext());
        }
        for (int i = 0; i < this.f12094h; i++) {
            JSONArray optJSONArray = this.f12092f.optJSONArray(i);
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
            WheelView3d wheelView3d = (WheelView3d) this.f12091e.getChildAt(i);
            wheelView3d.setAdapter(new d.b.g0.a.q1.a.f.a.a(arrayList));
            wheelView3d.setCurrentItem(this.f12093g.optInt(i));
            if (arrayList.size() <= 3) {
                wheelView3d.setCyclic(false);
            }
        }
    }

    public void j(int i, JSONArray jSONArray, int i2) {
        g(i, jSONArray);
        h(i, i2);
        k(i, jSONArray, i2);
    }

    public final void k(int i, JSONArray jSONArray, int i2) {
        WheelView3d wheelView3d = (WheelView3d) this.f12091e.getChildAt(i);
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
            if (p) {
                Log.d("BdMultiPicker", "update wheel UI dataArray : " + jSONArray);
            }
            if (arrayList.size() <= 3) {
                wheelView3d.setCyclic(false);
            }
            wheelView3d.setAdapter(new d.b.g0.a.q1.a.f.a.a(arrayList));
            wheelView3d.setCurrentItem(i2);
        }
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f12092f = jSONArray;
            this.f12094h = jSONArray.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f12093g = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        this.i = bVar;
    }

    public void setMultiWheelData(JSONArray jSONArray, JSONArray jSONArray2) {
        if (p) {
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

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12092f = new JSONArray();
        this.f12093g = new JSONArray();
        this.f12094h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a();
        d(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12092f = new JSONArray();
        this.f12093g = new JSONArray();
        this.f12094h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a();
        d(context);
    }
}
