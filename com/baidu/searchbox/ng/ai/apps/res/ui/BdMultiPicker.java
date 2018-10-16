package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.WheelView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BdMultiPicker extends LinearLayout {
    private static final boolean DEBUG = false;
    private static final int DP_WHEEL_HEIGHT = 100;
    private static final int DP_WHEEL_WIDTH = 85;
    private static final String TAG = "BdMultiPicker";
    private JSONArray mDataArray;
    private JSONArray mDataIndex;
    private BdGallery.OnEndFlingListener mEndFlingListener;
    private boolean mHasInited;
    private OnMultiSelectedChangedListener mSelectedChangedListener;
    private int mSpaceSize;
    private int mWheelColumn;
    private LinearLayout mWheelContainer;
    private int mWheelHeight;
    private int mWheelWidth;

    /* loaded from: classes2.dex */
    public interface OnMultiSelectedChangedListener {
        void onMultiSelectedChanged(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    public BdMultiPicker(Context context) {
        super(context);
        this.mDataArray = new JSONArray();
        this.mDataIndex = new JSONArray();
        this.mWheelColumn = 0;
        this.mSpaceSize = 16;
        this.mEndFlingListener = new BdGallery.OnEndFlingListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery.OnEndFlingListener
            public void onEndFling(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (BdMultiPicker.this.updateIndex(intValue, selectedItemPosition) && BdMultiPicker.this.mSelectedChangedListener != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", selectedItemPosition);
                    } catch (JSONException e) {
                    }
                    BdMultiPicker.this.mSelectedChangedListener.onMultiSelectedChanged(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDataArray = new JSONArray();
        this.mDataIndex = new JSONArray();
        this.mWheelColumn = 0;
        this.mSpaceSize = 16;
        this.mEndFlingListener = new BdGallery.OnEndFlingListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery.OnEndFlingListener
            public void onEndFling(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (BdMultiPicker.this.updateIndex(intValue, selectedItemPosition) && BdMultiPicker.this.mSelectedChangedListener != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", selectedItemPosition);
                    } catch (JSONException e) {
                    }
                    BdMultiPicker.this.mSelectedChangedListener.onMultiSelectedChanged(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDataArray = new JSONArray();
        this.mDataIndex = new JSONArray();
        this.mWheelColumn = 0;
        this.mSpaceSize = 16;
        this.mEndFlingListener = new BdGallery.OnEndFlingListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery.OnEndFlingListener
            public void onEndFling(BdGallery bdGallery) {
                int selectedItemPosition = bdGallery.getSelectedItemPosition();
                int intValue = ((Integer) bdGallery.getTag()).intValue();
                if (BdMultiPicker.this.updateIndex(intValue, selectedItemPosition) && BdMultiPicker.this.mSelectedChangedListener != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put("current", selectedItemPosition);
                    } catch (JSONException e) {
                    }
                    BdMultiPicker.this.mSelectedChangedListener.onMultiSelectedChanged(BdMultiPicker.this, jSONObject);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.aiapps_multipicker_layout, this);
        this.mWheelContainer = (LinearLayout) findViewById(R.id.wheel_container);
        this.mWheelWidth = AiAppsUIUtils.dip2px(context, 85.0f);
        this.mWheelHeight = AiAppsUIUtils.dip2px(context, 100.0f);
        this.mSpaceSize = AiAppsUIUtils.dip2px(context, this.mSpaceSize);
    }

    private void initWheelView(Context context) {
        for (int i = 0; i < this.mWheelColumn; i++) {
            WheelView wheelView = new WheelView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mWheelWidth, this.mWheelHeight);
            wheelView.setOnEndFlingListener(this.mEndFlingListener);
            wheelView.setTag(Integer.valueOf(i));
            wheelView.setSpacing(this.mSpaceSize);
            wheelView.setScrollCycle(true);
            wheelView.setAdapter((SpinnerAdapter) new MultiPickerAdapter(context));
            wheelView.setSelectorDrawable(getResources().getDrawable(R.color.aiapps_transparent));
            this.mWheelContainer.addView(wheelView, layoutParams);
        }
        this.mHasInited = true;
    }

    public void setMultiWheelData(JSONArray jSONArray, JSONArray jSONArray2) {
        setDataArray(jSONArray);
        setDataIndex(jSONArray2);
        updateUI();
    }

    public void setDataArray(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mDataArray = jSONArray;
            this.mWheelColumn = this.mDataArray.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mDataIndex = jSONArray;
        }
    }

    public void setMultiSelectedListener(OnMultiSelectedChangedListener onMultiSelectedChangedListener) {
        this.mSelectedChangedListener = onMultiSelectedChangedListener;
    }

    public JSONArray getCurrentIndex() {
        return this.mDataIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateIndex(int i, int i2) {
        if (this.mDataIndex == null || i < 0 || i > this.mDataIndex.length() - 1) {
            return false;
        }
        try {
            if (this.mDataIndex.getInt(i) != i2) {
                this.mDataIndex.put(i, i2);
                return true;
            }
            return false;
        } catch (JSONException e) {
            return false;
        }
    }

    private boolean updateData(int i, JSONArray jSONArray) {
        if (this.mDataArray == null || i < 0 || i > this.mDataArray.length() - 1) {
            return false;
        }
        try {
            this.mDataArray.put(i, jSONArray);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public void updateWheel(int i, JSONArray jSONArray, int i2) {
        updateData(i, jSONArray);
        updateIndex(i, i2);
        updateWheelUI(i, jSONArray, i2);
    }

    private void updateWheelUI(int i, JSONArray jSONArray, int i2) {
        WheelView wheelView;
        if (jSONArray != null && jSONArray.length() > 0 && (wheelView = (WheelView) this.mWheelContainer.getChildAt(i)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
            ((MultiPickerAdapter) wheelView.getAdapter()).setData(arrayList);
            wheelView.setSelection(i2);
        }
    }

    public void updateUI() {
        if (this.mWheelColumn != 0) {
            if (!this.mHasInited) {
                initWheelView(getContext());
            }
            for (int i = 0; i < this.mWheelColumn; i++) {
                JSONArray optJSONArray = this.mDataArray.optJSONArray(i);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    if (arrayList.size() > 0) {
                        WheelView wheelView = (WheelView) this.mWheelContainer.getChildAt(i);
                        ((MultiPickerAdapter) wheelView.getAdapter()).setData(arrayList);
                        wheelView.setSelection(this.mDataIndex.optInt(i));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class MultiPickerAdapter extends BaseAdapter {
        private int mContentTextColor;
        private Context mContext;
        private int mHeight;
        private List<String> mData = null;
        private int mWidth = -1;

        public MultiPickerAdapter(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContentTextColor = -16777216;
            this.mContext = context;
            this.mHeight = AiAppsUIUtils.dip2px(context, this.mHeight);
            this.mContentTextColor = AppRuntime.getAppContext().getResources().getColor(R.color.aiapps_data_picker_color);
        }

        public void setData(List<String> list) {
            this.mData = list;
            notifyDataSetChanged();
        }

        public void setItemSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
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
                view = createView(this.mContext, i, viewGroup);
            }
            buildView(i, view);
            return view;
        }

        protected View createView(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.LayoutParams(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextColor(this.mContentTextColor);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView.setBackgroundColor(context.getResources().getColor(R.color.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void buildView(int i, View view) {
            ((TextView) view).setText(this.mData.get(i));
        }
    }
}
