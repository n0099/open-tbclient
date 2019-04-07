package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.wheelview.BdGallery;
import com.baidu.swan.apps.res.ui.wheelview.WheelView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BdMultiPicker extends LinearLayout {
    private static final boolean DEBUG;
    private int aFI;
    private BdGallery.c aFJ;
    private LinearLayout aFN;
    private JSONArray aFO;
    private JSONArray aFP;
    private int aFQ;
    private int aFR;
    private int aFS;
    private b aFT;
    private boolean aFU;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    static {
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.aFO = new JSONArray();
        this.aFP = new JSONArray();
        this.aFS = 0;
        this.aFI = 16;
        this.aFJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.C(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.aFT != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", selectedItemPosition);
                    } catch (JSONException e) {
                        if (BdMultiPicker.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    BdMultiPicker.this.aFT.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFO = new JSONArray();
        this.aFP = new JSONArray();
        this.aFS = 0;
        this.aFI = 16;
        this.aFJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.C(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.aFT != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", selectedItemPosition);
                    } catch (JSONException e) {
                        if (BdMultiPicker.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    BdMultiPicker.this.aFT.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFO = new JSONArray();
        this.aFP = new JSONArray();
        this.aFS = 0;
        this.aFI = 16;
        this.aFJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.C(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.aFT != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", selectedItemPosition);
                    } catch (JSONException e) {
                        if (BdMultiPicker.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    BdMultiPicker.this.aFT.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_multipicker_layout, this);
        this.aFN = (LinearLayout) findViewById(a.f.wheel_container);
        this.aFQ = x.dip2px(context, 85.0f);
        this.aFR = x.dip2px(context, 100.0f);
        this.aFI = x.dip2px(context, this.aFI);
    }

    private void bS(Context context) {
        for (int i = 0; i < this.aFS; i++) {
            WheelView wheelView = new WheelView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aFQ, this.aFR);
            wheelView.setOnEndFlingListener(this.aFJ);
            wheelView.setTag(Integer.valueOf(i));
            wheelView.setSpacing(this.aFI);
            wheelView.setScrollCycle(true);
            wheelView.setAdapter((SpinnerAdapter) new a(context));
            wheelView.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
            this.aFN.addView(wheelView, layoutParams);
        }
        this.aFU = true;
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
        GP();
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aFO = jSONArray;
            this.aFS = this.aFO.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aFP = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        this.aFT = bVar;
    }

    public JSONArray getCurrentIndex() {
        if (DEBUG && this.aFP != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.aFP.toString());
        }
        return this.aFP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(int i, int i2) {
        if (this.aFP == null || i < 0 || i > this.aFP.length() - 1) {
            return false;
        }
        try {
            if (this.aFP.getInt(i) != i2) {
                this.aFP.put(i, i2);
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

    private boolean b(int i, JSONArray jSONArray) {
        if (this.aFO == null || i < 0 || i > this.aFO.length() - 1) {
            return false;
        }
        try {
            this.aFO.put(i, jSONArray);
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
        b(i, jSONArray);
        C(i, i2);
        b(i, jSONArray, i2);
    }

    private void b(int i, JSONArray jSONArray, int i2) {
        WheelView wheelView;
        if (jSONArray != null && jSONArray.length() > 0 && (wheelView = (WheelView) this.aFN.getChildAt(i)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
            ((a) wheelView.getAdapter()).setData(arrayList);
            wheelView.setSelection(i2);
        }
    }

    public void GP() {
        if (this.aFS != 0) {
            if (!this.aFU) {
                bS(getContext());
            }
            for (int i = 0; i < this.aFS; i++) {
                JSONArray optJSONArray = this.aFO.optJSONArray(i);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    if (arrayList.size() > 0) {
                        WheelView wheelView = (WheelView) this.aFN.getChildAt(i);
                        ((a) wheelView.getAdapter()).setData(arrayList);
                        wheelView.setSelection(this.aFP.optInt(i));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aFM;
        private Context mContext;
        private int mHeight;
        private List<String> mData = null;
        private int mWidth = -1;

        public a(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.aFM = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.mHeight = x.dip2px(context, this.mHeight);
            this.aFM = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
        }

        public void setData(List<String> list) {
            this.mData = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mData != null) {
                return this.mData.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.mData != null) {
                return this.mData.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = a(this.mContext, i, viewGroup);
            }
            b(i, view);
            return view;
        }

        protected View a(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.b(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextColor(this.aFM);
            textView2.setSingleLine(true);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.mData.get(i));
        }
    }
}
