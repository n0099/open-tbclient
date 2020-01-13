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
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements a.InterfaceC0307a {
    private EditText bXM;
    private a bXO;
    private Context mContext;
    private List<com.baidu.swan.bdprivate.address.c.a> mDataList;
    private Map<String, Object> bXN = new HashMap();
    private Map<String, Boolean> bXP = new HashMap(5);
    private Map<String, Boolean> bXQ = new HashMap(4);

    /* loaded from: classes10.dex */
    public interface a {
        void ee(boolean z);
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
        this.bXQ = map;
    }

    public void s(Map<String, Boolean> map) {
        this.bXP = map;
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
        this.bXO = aVar;
    }

    public boolean afD() {
        return afO();
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
        TextView textView = cVar.bXT;
        EditText editText = cVar.bXU;
        ImageView imageView = cVar.bXV;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.bYe) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0305b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.swan.bdprivate.address.view.a aVar = new com.baidu.swan.bdprivate.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.agh();
                }
            });
            this.bXM = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState()) {
            return;
        }
        cVar.bXL.setBackgroundColor(Color.parseColor("#191919"));
        cVar.bXT.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.bXU.setTextColor(Color.parseColor("#666666"));
        cVar.bXU.setHintTextColor(Color.parseColor("#333333"));
        cVar.bXW.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.swan.bdprivate.address.view.a.InterfaceC0307a
    public void ad(List<d> list) {
        if (list != null && list.size() == 3 && this.bXM != null) {
            this.bXM.setTag(b.e.region_province, list.get(0));
            this.bXM.setTag(b.e.region_city, list.get(1));
            this.bXM.setTag(b.e.region_county, list.get(2));
            this.bXM.setText(d.af(list));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bXN;
    }

    /* renamed from: com.baidu.swan.bdprivate.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0305b implements TextWatcher {
        private String bXS;
        private EditText mEditText;

        public C0305b(EditText editText) {
            this.mEditText = editText;
            this.bXS = this.mEditText.getText().toString();
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
                if (editable == null || !TextUtils.equals(editable.toString(), this.bXS)) {
                    b.this.bXP.put(valueOf, true);
                } else {
                    b.this.bXP.put(valueOf, false);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.bXM == null) {
                        b.this.bXN.put(valueOf, obj);
                    } else {
                        d hc = b.this.hc(b.e.region_province);
                        if (hc != null) {
                            b.this.bXN.put("l1", hc);
                        }
                        d hc2 = b.this.hc(b.e.region_city);
                        if (hc2 != null) {
                            b.this.bXN.put("l2", hc2);
                        }
                        b.this.bXN.put("l3", b.this.hc(b.e.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.bXQ.put(valueOf, true);
                    }
                    if (b.this.afN() && b.this.afO()) {
                        b.this.bXO.ee(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.bXQ.put(valueOf, false);
                    b.this.bXO.ee(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afN() {
        for (Boolean bool : this.bXQ.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afO() {
        for (Boolean bool : this.bXP.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hc(int i) {
        Object tag;
        if (this.bXM == null || (tag = this.bXM.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c {
        private View bXL;
        private TextView bXT;
        private EditText bXU;
        private ImageView bXV;
        private View bXW;

        public c(View view) {
            this.bXL = view;
            this.bXT = (TextView) view.findViewById(b.e.delivery_label);
            this.bXU = (EditText) view.findViewById(b.e.delivery_content);
            this.bXV = (ImageView) view.findViewById(b.e.delivery_arrow);
            this.bXW = view.findViewById(b.e.delivery_highlight_line);
        }
    }
}
