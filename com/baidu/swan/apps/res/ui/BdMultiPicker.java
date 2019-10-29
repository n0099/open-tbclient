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
import com.baidu.swan.apps.an.z;
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
    private int bbW;
    private BdGallery.c bbX;
    private LinearLayout bcb;
    private JSONArray bcc;
    private JSONArray bcd;
    private int bce;
    private int bcf;
    private int bcg;
    private b bch;
    private boolean bci;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    static {
        DEBUG = com.baidu.swan.apps.b.DEBUG;
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.bcc = new JSONArray();
        this.bcd = new JSONArray();
        this.bcg = 0;
        this.bbW = 16;
        this.bbX = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.J(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.bch != null) {
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
                    BdMultiPicker.this.bch.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcc = new JSONArray();
        this.bcd = new JSONArray();
        this.bcg = 0;
        this.bbW = 16;
        this.bbX = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.J(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.bch != null) {
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
                    BdMultiPicker.this.bch.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcc = new JSONArray();
        this.bcd = new JSONArray();
        this.bcg = 0;
        this.bbW = 16;
        this.bbX = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (!BdMultiPicker.this.J(intValue, selectedItemPosition)) {
                    if (BdMultiPicker.DEBUG) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (BdMultiPicker.this.bch != null) {
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
                    BdMultiPicker.this.bch.a(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_multipicker_layout, this);
        this.bcb = (LinearLayout) findViewById(a.f.wheel_container);
        this.bce = z.dip2px(context, 85.0f);
        this.bcf = z.dip2px(context, 100.0f);
        this.bbW = z.dip2px(context, this.bbW);
    }

    private void bt(Context context) {
        for (int i = 0; i < this.bcg; i++) {
            WheelView wheelView = new WheelView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bce, this.bcf);
            wheelView.setOnEndFlingListener(this.bbX);
            wheelView.setTag(Integer.valueOf(i));
            wheelView.setSpacing(this.bbW);
            wheelView.setScrollCycle(true);
            wheelView.setAdapter((SpinnerAdapter) new a(context));
            wheelView.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
            this.bcb.addView(wheelView, layoutParams);
        }
        this.bci = true;
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
            this.bcc = jSONArray;
            this.bcg = this.bcc.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bcd = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        this.bch = bVar;
    }

    public JSONArray getCurrentIndex() {
        if (DEBUG && this.bcd != null) {
            Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.bcd.toString());
        }
        return this.bcd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(int i, int i2) {
        if (this.bcd == null || i < 0 || i > this.bcd.length() - 1) {
            return false;
        }
        try {
            if (this.bcd.getInt(i) != i2) {
                this.bcd.put(i, i2);
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
        if (this.bcc == null || i < 0 || i > this.bcc.length() - 1) {
            return false;
        }
        try {
            this.bcc.put(i, jSONArray);
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
        J(i, i2);
        b(i, jSONArray, i2);
    }

    private void b(int i, JSONArray jSONArray, int i2) {
        WheelView wheelView;
        if (jSONArray != null && jSONArray.length() > 0 && (wheelView = (WheelView) this.bcb.getChildAt(i)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
            ((a) wheelView.getAdapter()).setData(arrayList);
            wheelView.setSelection(i2);
        }
    }

    public void updateUI() {
        if (this.bcg != 0) {
            if (!this.bci) {
                bt(getContext());
            }
            for (int i = 0; i < this.bcg; i++) {
                JSONArray optJSONArray = this.bcc.optJSONArray(i);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    if (arrayList.size() > 0) {
                        WheelView wheelView = (WheelView) this.bcb.getChildAt(i);
                        ((a) wheelView.getAdapter()).setData(arrayList);
                        wheelView.setSelection(this.bcd.optInt(i));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int bca;
        private Context mContext;
        private int mHeight;
        private List<String> mData = null;
        private int mWidth = -1;

        public a(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.bca = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.mHeight = z.dip2px(context, this.mHeight);
            this.bca = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            c(i, view);
            return view;
        }

        protected View a(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.b(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextColor(this.bca);
            textView2.setSingleLine(true);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void c(int i, View view) {
            ((TextView) view).setText(this.mData.get(i));
        }
    }
}
