package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BdMultiPicker extends LinearLayout {
    private static final boolean DEBUG;
    private int bKk;
    private LinearLayout bKm;
    private JSONArray bKn;
    private JSONArray bKo;
    private int bKp;
    private a bKq;
    private int bKr;
    private int bKs;
    private com.baidu.swan.apps.res.ui.wheelview3d.c.b bKt;
    private boolean mHasInited;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface a {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    static {
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.bKn = new JSONArray();
        this.bKo = new JSONArray();
        this.bKp = 0;
        this.bKr = 16;
        this.bKs = 15;
        this.bKt = new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                int currentItem = wheelView3d.getCurrentItem();
                int intValue = ((Integer) wheelView3d.getTag()).intValue();
                if (!BdMultiPicker.this.ac(intValue, currentItem)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.bKq != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", currentItem);
                    } catch (JSONException e) {
                        if (BdMultiPicker.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    BdMultiPicker.this.bKq.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKn = new JSONArray();
        this.bKo = new JSONArray();
        this.bKp = 0;
        this.bKr = 16;
        this.bKs = 15;
        this.bKt = new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i) {
                int currentItem = wheelView3d.getCurrentItem();
                int intValue = ((Integer) wheelView3d.getTag()).intValue();
                if (!BdMultiPicker.this.ac(intValue, currentItem)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.bKq != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", currentItem);
                    } catch (JSONException e) {
                        if (BdMultiPicker.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    BdMultiPicker.this.bKq.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKn = new JSONArray();
        this.bKo = new JSONArray();
        this.bKp = 0;
        this.bKr = 16;
        this.bKs = 15;
        this.bKt = new com.baidu.swan.apps.res.ui.wheelview3d.c.b() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview3d.c.b
            public void a(WheelView3d wheelView3d, int i2) {
                int currentItem = wheelView3d.getCurrentItem();
                int intValue = ((Integer) wheelView3d.getTag()).intValue();
                if (!BdMultiPicker.this.ac(intValue, currentItem)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.bKq != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", currentItem);
                    } catch (JSONException e) {
                        if (BdMultiPicker.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    BdMultiPicker.this.bKq.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_multipicker_layout, this);
        this.bKm = (LinearLayout) findViewById(a.f.wheel_container);
        this.bKr = af.dip2px(context, this.bKr);
        this.bKs = af.dip2px(context, this.bKs);
    }

    private void cq(Context context) {
        this.mTextSize = af.dip2px(context, 16.0f);
        this.bKk = af.dip2px(context, 14.0f);
        for (int i = 0; i < this.bKp; i++) {
            WheelView3d wheelView3d = new WheelView3d(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            wheelView3d.setOnItemSelectedListener(this.bKt);
            wheelView3d.setTag(Integer.valueOf(i));
            wheelView3d.setCyclic(true);
            wheelView3d.setCenterTextSize(this.mTextSize);
            wheelView3d.setOuterTextSize(this.bKk);
            wheelView3d.setDividerType(WheelView3d.DividerType.FILL);
            wheelView3d.setDividerColor(0);
            wheelView3d.setGravity(17);
            wheelView3d.setTextColorCenter(ViewCompat.MEASURED_STATE_MASK);
            wheelView3d.setTextColorOut(ViewCompat.MEASURED_STATE_MASK);
            wheelView3d.setLineSpacingMultiplier(3.0f);
            wheelView3d.setVisibleItem(7);
            b(wheelView3d, i);
            this.bKm.addView(wheelView3d, layoutParams);
        }
        this.mHasInited = true;
    }

    private void b(WheelView3d wheelView3d, int i) {
        if (this.bKp >= 2) {
            if (i == 0) {
                wheelView3d.setGravityOffset(-this.bKs);
            }
            if (i == this.bKp - 1) {
                wheelView3d.setGravityOffset(this.bKs);
            }
        }
    }

    public void setMultiWheelData(JSONArray jSONArray, JSONArray jSONArray2) {
        if (DEBUG) {
            if (jSONArray != null) {
                Log.i("BdMultiPicker", "setMultiWheelData: dataArray=" + jSONArray.toString());
            }
            if (jSONArray2 != null) {
                Log.i("BdMultiPicker", "setMultiWheelData: dataIndex=" + jSONArray2.toString());
            }
        }
        setDataArray(jSONArray);
        setDataIndex(jSONArray2);
        updateUI();
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bKn = jSONArray;
            this.bKp = this.bKn.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bKo = jSONArray;
        }
    }

    public void setMultiSelectedListener(a aVar) {
        this.bKq = aVar;
    }

    public JSONArray getCurrentIndex() {
        if (DEBUG && this.bKo != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.bKo.toString());
        }
        return this.bKo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ac(int i, int i2) {
        if (this.bKo == null || i < 0 || i > this.bKo.length() - 1) {
            return false;
        }
        try {
            if (this.bKo.getInt(i) != i2) {
                this.bKo.put(i, i2);
                return true;
            }
            return false;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private boolean a(int i, JSONArray jSONArray) {
        if (this.bKn == null || i < 0 || i > this.bKn.length() - 1) {
            return false;
        }
        try {
            this.bKn.put(i, jSONArray);
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        a(i, jSONArray);
        ac(i, i2);
        b(i, jSONArray, i2);
    }

    private void b(int i, JSONArray jSONArray, int i2) {
        WheelView3d wheelView3d = (WheelView3d) this.bKm.getChildAt(i);
        if (wheelView3d != null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null || jSONArray.length() <= 0) {
                arrayList.add("");
            } else {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(jSONArray.optString(i3));
                }
            }
            if (DEBUG) {
                Log.d("BdMultiPicker", "update wheel UI dataArray : " + jSONArray);
            }
            if (arrayList.size() <= 3) {
                wheelView3d.setCyclic(false);
            }
            wheelView3d.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.a(arrayList));
            wheelView3d.setCurrentItem(i2);
        }
    }

    public void updateUI() {
        ArrayList arrayList;
        if (this.bKp != 0) {
            if (!this.mHasInited) {
                cq(getContext());
            }
            for (int i = 0; i < this.bKp; i++) {
                JSONArray optJSONArray = this.bKn.optJSONArray(i);
                ArrayList arrayList2 = null;
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList2.add(optString);
                        }
                    }
                }
                if (arrayList2 == null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add("");
                    arrayList = arrayList3;
                } else {
                    arrayList = arrayList2;
                }
                WheelView3d wheelView3d = (WheelView3d) this.bKm.getChildAt(i);
                wheelView3d.setAdapter(new com.baidu.swan.apps.res.ui.wheelview3d.a.a(arrayList));
                wheelView3d.setCurrentItem(this.bKo.optInt(i));
                if (arrayList.size() <= 3) {
                    wheelView3d.setCyclic(false);
                }
            }
        }
    }
}
