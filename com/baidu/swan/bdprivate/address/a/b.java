package com.baidu.swan.bdprivate.address.a;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.bdprivate.address.c.d;
import com.baidu.swan.bdprivate.address.view.a;
import com.baidu.swan.bdprivate.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class b extends BaseAdapter implements a.InterfaceC0317a {
    private EditText cbR;
    private a cbT;
    private Context mContext;
    private List<com.baidu.swan.bdprivate.address.c.a> mDataList;
    private Map<String, Object> cbS = new HashMap();
    private Map<String, Boolean> cbU = new HashMap(5);
    private Map<String, Boolean> cbV = new HashMap(4);

    /* loaded from: classes11.dex */
    public interface a {
        void el(boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hs */
    public com.baidu.swan.bdprivate.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void r(Map<String, Boolean> map) {
        this.cbV = map;
    }

    public void s(Map<String, Boolean> map) {
        this.cbU = map;
    }

    public void setData(List<com.baidu.swan.bdprivate.address.c.a> list) {
        if (list != null) {
            this.mDataList = list;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void setDeliveryEditChangedListener(a aVar) {
        this.cbT = aVar;
    }

    public boolean ahT() {
        return aie();
    }

    @Override // android.widget.Adapter
    @NonNull
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        c cVar;
        com.baidu.swan.bdprivate.address.c.a item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(b.f.delivery_edit_item_layout, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        a(cVar);
        TextView textView = cVar.cbY;
        EditText editText = cVar.cbZ;
        ImageView imageView = cVar.cca;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.ccj) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0315b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.swan.bdprivate.address.view.a aVar = new com.baidu.swan.bdprivate.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aix();
                }
            });
            this.cbR = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState()) {
            return;
        }
        cVar.cbQ.setBackgroundColor(Color.parseColor("#191919"));
        cVar.cbY.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.cbZ.setTextColor(Color.parseColor("#666666"));
        cVar.cbZ.setHintTextColor(Color.parseColor("#333333"));
        cVar.ccb.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.swan.bdprivate.address.view.a.InterfaceC0317a
    public void ad(List<d> list) {
        if (list != null && list.size() == 3 && this.cbR != null) {
            this.cbR.setTag(b.e.region_province, list.get(0));
            this.cbR.setTag(b.e.region_city, list.get(1));
            this.cbR.setTag(b.e.region_county, list.get(2));
            this.cbR.setText(d.af(list));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cbS;
    }

    /* renamed from: com.baidu.swan.bdprivate.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0315b implements TextWatcher {
        private String cbX;
        private EditText mEditText;

        public C0315b(EditText editText) {
            this.mEditText = editText;
            this.cbX = this.mEditText.getText().toString();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String valueOf = String.valueOf(this.mEditText.getTag());
            if (!TextUtils.isEmpty(valueOf)) {
                if (editable == null || !TextUtils.equals(editable.toString(), this.cbX)) {
                    b.this.cbU.put(valueOf, true);
                } else {
                    b.this.cbU.put(valueOf, false);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.cbR == null) {
                        b.this.cbS.put(valueOf, obj);
                    } else {
                        d ht = b.this.ht(b.e.region_province);
                        if (ht != null) {
                            b.this.cbS.put("l1", ht);
                        }
                        d ht2 = b.this.ht(b.e.region_city);
                        if (ht2 != null) {
                            b.this.cbS.put("l2", ht2);
                        }
                        b.this.cbS.put("l3", b.this.ht(b.e.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.cbV.put(valueOf, true);
                    }
                    if (b.this.aid() && b.this.aie()) {
                        b.this.cbT.el(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.cbV.put(valueOf, false);
                    b.this.cbT.el(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aid() {
        for (Boolean bool : this.cbV.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aie() {
        for (Boolean bool : this.cbU.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d ht(int i) {
        Object tag;
        if (this.cbR == null || (tag = this.cbR.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c {
        private View cbQ;
        private TextView cbY;
        private EditText cbZ;
        private ImageView cca;
        private View ccb;

        public c(View view) {
            this.cbQ = view;
            this.cbY = (TextView) view.findViewById(b.e.delivery_label);
            this.cbZ = (EditText) view.findViewById(b.e.delivery_content);
            this.cca = (ImageView) view.findViewById(b.e.delivery_arrow);
            this.ccb = view.findViewById(b.e.delivery_highlight_line);
        }
    }
}
