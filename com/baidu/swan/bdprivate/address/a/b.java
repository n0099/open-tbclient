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
/* loaded from: classes9.dex */
public class b extends BaseAdapter implements a.InterfaceC0305a {
    private EditText bXA;
    private a bXC;
    private Context mContext;
    private List<com.baidu.swan.bdprivate.address.c.a> mDataList;
    private Map<String, Object> bXB = new HashMap();
    private Map<String, Boolean> bXD = new HashMap(5);
    private Map<String, Boolean> bXE = new HashMap(4);

    /* loaded from: classes9.dex */
    public interface a {
        void dZ(boolean z);
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
    /* renamed from: hb */
    public com.baidu.swan.bdprivate.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void r(Map<String, Boolean> map) {
        this.bXE = map;
    }

    public void s(Map<String, Boolean> map) {
        this.bXD = map;
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
        this.bXC = aVar;
    }

    public boolean afk() {
        return afv();
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
        TextView textView = cVar.bXH;
        EditText editText = cVar.bXI;
        ImageView imageView = cVar.bXJ;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.bXS) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0303b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.swan.bdprivate.address.view.a aVar = new com.baidu.swan.bdprivate.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.afO();
                }
            });
            this.bXA = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState()) {
            return;
        }
        cVar.bXz.setBackgroundColor(Color.parseColor("#191919"));
        cVar.bXH.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.bXI.setTextColor(Color.parseColor("#666666"));
        cVar.bXI.setHintTextColor(Color.parseColor("#333333"));
        cVar.bXK.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.swan.bdprivate.address.view.a.InterfaceC0305a
    public void ae(List<d> list) {
        if (list != null && list.size() == 3 && this.bXA != null) {
            this.bXA.setTag(b.e.region_province, list.get(0));
            this.bXA.setTag(b.e.region_city, list.get(1));
            this.bXA.setTag(b.e.region_county, list.get(2));
            this.bXA.setText(d.ag(list));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bXB;
    }

    /* renamed from: com.baidu.swan.bdprivate.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0303b implements TextWatcher {
        private String bXG;
        private EditText mEditText;

        public C0303b(EditText editText) {
            this.mEditText = editText;
            this.bXG = this.mEditText.getText().toString();
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
                if (editable == null || !TextUtils.equals(editable.toString(), this.bXG)) {
                    b.this.bXD.put(valueOf, true);
                } else {
                    b.this.bXD.put(valueOf, false);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.bXA == null) {
                        b.this.bXB.put(valueOf, obj);
                    } else {
                        d hc = b.this.hc(b.e.region_province);
                        if (hc != null) {
                            b.this.bXB.put("l1", hc);
                        }
                        d hc2 = b.this.hc(b.e.region_city);
                        if (hc2 != null) {
                            b.this.bXB.put("l2", hc2);
                        }
                        b.this.bXB.put("l3", b.this.hc(b.e.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.bXE.put(valueOf, true);
                    }
                    if (b.this.afu() && b.this.afv()) {
                        b.this.bXC.dZ(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.bXE.put(valueOf, false);
                    b.this.bXC.dZ(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afu() {
        for (Boolean bool : this.bXE.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afv() {
        for (Boolean bool : this.bXD.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hc(int i) {
        Object tag;
        if (this.bXA == null || (tag = this.bXA.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        private TextView bXH;
        private EditText bXI;
        private ImageView bXJ;
        private View bXK;
        private View bXz;

        public c(View view) {
            this.bXz = view;
            this.bXH = (TextView) view.findViewById(b.e.delivery_label);
            this.bXI = (EditText) view.findViewById(b.e.delivery_content);
            this.bXJ = (ImageView) view.findViewById(b.e.delivery_arrow);
            this.bXK = view.findViewById(b.e.delivery_highlight_line);
        }
    }
}
