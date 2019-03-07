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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
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
    private int aFE;
    private BdGallery.c aFF;
    private LinearLayout aFJ;
    private JSONArray aFK;
    private JSONArray aFL;
    private int aFM;
    private int aFN;
    private int aFO;
    private b aFP;
    private boolean aFQ;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    static {
        DEBUG = com.baidu.swan.apps.c.DEBUG;
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.aFK = new JSONArray();
        this.aFL = new JSONArray();
        this.aFO = 0;
        this.aFE = 16;
        this.aFF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.C(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.aFP != null) {
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
                    BdMultiPicker.this.aFP.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFK = new JSONArray();
        this.aFL = new JSONArray();
        this.aFO = 0;
        this.aFE = 16;
        this.aFF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.C(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.aFP != null) {
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
                    BdMultiPicker.this.aFP.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFK = new JSONArray();
        this.aFL = new JSONArray();
        this.aFO = 0;
        this.aFE = 16;
        this.aFF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.C(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.aFP != null) {
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
                    BdMultiPicker.this.aFP.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(b.g.aiapps_multipicker_layout, this);
        this.aFJ = (LinearLayout) findViewById(b.f.wheel_container);
        this.aFM = x.dip2px(context, 85.0f);
        this.aFN = x.dip2px(context, 100.0f);
        this.aFE = x.dip2px(context, this.aFE);
    }

    private void bS(Context context) {
        for (int i = 0; i < this.aFO; i++) {
            WheelView wheelView = new WheelView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aFM, this.aFN);
            wheelView.setOnEndFlingListener(this.aFF);
            wheelView.setTag(Integer.valueOf(i));
            wheelView.setSpacing(this.aFE);
            wheelView.setScrollCycle(true);
            wheelView.setAdapter((SpinnerAdapter) new a(context));
            wheelView.setSelectorDrawable(getResources().getDrawable(b.c.aiapps_transparent));
            this.aFJ.addView(wheelView, layoutParams);
        }
        this.aFQ = true;
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
        GR();
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aFK = jSONArray;
            this.aFO = this.aFK.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aFL = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        this.aFP = bVar;
    }

    public JSONArray getCurrentIndex() {
        if (DEBUG && this.aFL != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.aFL.toString());
        }
        return this.aFL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(int i, int i2) {
        if (this.aFL == null || i < 0 || i > this.aFL.length() - 1) {
            return false;
        }
        try {
            if (this.aFL.getInt(i) != i2) {
                this.aFL.put(i, i2);
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
        if (this.aFK == null || i < 0 || i > this.aFK.length() - 1) {
            return false;
        }
        try {
            this.aFK.put(i, jSONArray);
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
        if (jSONArray != null && jSONArray.length() > 0 && (wheelView = (WheelView) this.aFJ.getChildAt(i)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
            ((a) wheelView.getAdapter()).setData(arrayList);
            wheelView.setSelection(i2);
        }
    }

    public void GR() {
        if (this.aFO != 0) {
            if (!this.aFQ) {
                bS(getContext());
            }
            for (int i = 0; i < this.aFO; i++) {
                JSONArray optJSONArray = this.aFK.optJSONArray(i);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    if (arrayList.size() > 0) {
                        WheelView wheelView = (WheelView) this.aFJ.getChildAt(i);
                        ((a) wheelView.getAdapter()).setData(arrayList);
                        wheelView.setSelection(this.aFL.optInt(i));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aFI;
        private Context mContext;
        private int mHeight;
        private List<String> mData = null;
        private int mWidth = -1;

        public a(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.aFI = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.mHeight = x.dip2px(context, this.mHeight);
            this.aFI = AppRuntime.getAppContext().getResources().getColor(b.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aFI);
            textView2.setSingleLine(true);
            textView.setBackgroundColor(context.getResources().getColor(b.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.mData.get(i));
        }
    }
}
