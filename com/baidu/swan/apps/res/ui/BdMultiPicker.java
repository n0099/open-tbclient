package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BdMultiPicker extends LinearLayout {
    public static final boolean p = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f11204e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f11205f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f11206g;

    /* renamed from: h  reason: collision with root package name */
    public int f11207h;

    /* renamed from: i  reason: collision with root package name */
    public b f11208i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public d.a.m0.a.z1.a.e.c.b o;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.z1.a.e.c.b {
        public a() {
        }

        @Override // d.a.m0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            int currentItem = wheelView3d.getCurrentItem();
            int intValue = ((Integer) wheelView3d.getTag()).intValue();
            if (!BdMultiPicker.this.h(intValue, currentItem)) {
                if (BdMultiPicker.p) {
                    Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                }
            } else if (BdMultiPicker.this.f11208i != null) {
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
                BdMultiPicker.this.f11208i.a(BdMultiPicker.this, jSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.f11205f = new JSONArray();
        this.f11206g = new JSONArray();
        this.f11207h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a();
        d(context);
    }

    public final void d(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(g.aiapps_multipicker_layout, this);
        this.f11204e = (LinearLayout) findViewById(f.wheel_container);
        this.k = n0.f(context, this.k);
        this.n = n0.f(context, this.n);
    }

    public final void e(Context context) {
        this.l = n0.f(context, 16.0f);
        this.m = n0.f(context, 14.0f);
        for (int i2 = 0; i2 < this.f11207h; i2++) {
            WheelView3d wheelView3d = new WheelView3d(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            wheelView3d.setOnItemSelectedListener(this.o);
            wheelView3d.setTag(Integer.valueOf(i2));
            wheelView3d.setCyclic(false);
            wheelView3d.setCenterTextSize(this.l);
            wheelView3d.setOuterTextSize(this.m);
            wheelView3d.setDividerType(WheelView3d.DividerType.FILL);
            wheelView3d.setDividerColor(0);
            wheelView3d.setGravity(17);
            wheelView3d.setTextColorCenter(-16777216);
            wheelView3d.setTextColorOut(-16777216);
            wheelView3d.setLineSpacingMultiplier(3.0f);
            wheelView3d.setVisibleItem(7);
            f(wheelView3d, i2);
            this.f11204e.addView(wheelView3d, layoutParams);
        }
        this.j = true;
    }

    public final void f(WheelView3d wheelView3d, int i2) {
        if (this.f11207h < 2) {
            return;
        }
        if (i2 == 0) {
            wheelView3d.setGravityOffset(-this.n);
        }
        if (i2 == this.f11207h - 1) {
            wheelView3d.setGravityOffset(this.n);
        }
    }

    public final boolean g(int i2, JSONArray jSONArray) {
        JSONArray jSONArray2 = this.f11205f;
        if (jSONArray2 != null && i2 >= 0 && i2 <= jSONArray2.length() - 1) {
            try {
                this.f11205f.put(i2, jSONArray);
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
        if (p && this.f11206g != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.f11206g.toString());
        }
        return this.f11206g;
    }

    public final boolean h(int i2, int i3) {
        JSONArray jSONArray = this.f11206g;
        if (jSONArray != null && i2 >= 0 && i2 <= jSONArray.length() - 1) {
            try {
                if (this.f11206g.getInt(i2) != i3) {
                    this.f11206g.put(i2, i3);
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
        if (this.f11207h == 0) {
            return;
        }
        if (!this.j) {
            e(getContext());
        }
        for (int i2 = 0; i2 < this.f11207h; i2++) {
            JSONArray optJSONArray = this.f11205f.optJSONArray(i2);
            ArrayList arrayList = null;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
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
            WheelView3d wheelView3d = (WheelView3d) this.f11204e.getChildAt(i2);
            wheelView3d.setAdapter(new d.a.m0.a.z1.a.e.a.a(arrayList));
            wheelView3d.setCurrentItem(this.f11206g.optInt(i2));
            wheelView3d.setCyclic(false);
        }
    }

    public void j(int i2, JSONArray jSONArray, int i3) {
        g(i2, jSONArray);
        h(i2, i3);
        k(i2, jSONArray, i3);
    }

    public final void k(int i2, JSONArray jSONArray, int i3) {
        WheelView3d wheelView3d = (WheelView3d) this.f11204e.getChildAt(i2);
        if (wheelView3d != null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    arrayList.add(jSONArray.optString(i4));
                }
            } else {
                arrayList.add("");
            }
            if (p) {
                Log.d("BdMultiPicker", "update wheel UI dataArray : " + jSONArray);
            }
            wheelView3d.setCyclic(false);
            wheelView3d.setAdapter(new d.a.m0.a.z1.a.e.a.a(arrayList));
            wheelView3d.setCurrentItem(i3);
        }
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f11205f = jSONArray;
            this.f11207h = jSONArray.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f11206g = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        this.f11208i = bVar;
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
        this.f11205f = new JSONArray();
        this.f11206g = new JSONArray();
        this.f11207h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a();
        d(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11205f = new JSONArray();
        this.f11206g = new JSONArray();
        this.f11207h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a();
        d(context);
    }
}
