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
public class b extends BaseAdapter implements a.InterfaceC0368a {
    private EditText cBk;
    private a cBm;
    private Context mContext;
    private List<com.baidu.swan.bdprivate.address.c.a> mDataList;
    private Map<String, Object> cBl = new HashMap();
    private Map<String, Boolean> cBn = new HashMap(5);
    private Map<String, Boolean> cBo = new HashMap(4);

    /* loaded from: classes11.dex */
    public interface a {
        void fj(boolean z);
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
    /* renamed from: hz */
    public com.baidu.swan.bdprivate.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.cBo = map;
    }

    public void q(Map<String, Boolean> map) {
        this.cBn = map;
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
        this.cBm = aVar;
    }

    public boolean aqd() {
        return aqo();
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
        TextView textView = cVar.cBr;
        EditText editText = cVar.cBs;
        ImageView imageView = cVar.cBt;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.cBC) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0366b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.swan.bdprivate.address.view.a aVar = new com.baidu.swan.bdprivate.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aqH();
                }
            });
            this.cBk = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState()) {
            return;
        }
        cVar.cBj.setBackgroundColor(Color.parseColor("#191919"));
        cVar.cBr.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.cBs.setTextColor(Color.parseColor("#666666"));
        cVar.cBs.setHintTextColor(Color.parseColor("#333333"));
        cVar.cBu.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.swan.bdprivate.address.view.a.InterfaceC0368a
    public void al(List<d> list) {
        if (list != null && list.size() == 3 && this.cBk != null) {
            this.cBk.setTag(b.e.region_province, list.get(0));
            this.cBk.setTag(b.e.region_city, list.get(1));
            this.cBk.setTag(b.e.region_county, list.get(2));
            this.cBk.setText(d.an(list));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cBl;
    }

    /* renamed from: com.baidu.swan.bdprivate.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0366b implements TextWatcher {
        private String cBq;
        private EditText mEditText;

        public C0366b(EditText editText) {
            this.mEditText = editText;
            this.cBq = this.mEditText.getText().toString();
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
                if (editable == null || !TextUtils.equals(editable.toString(), this.cBq)) {
                    b.this.cBn.put(valueOf, true);
                } else {
                    b.this.cBn.put(valueOf, false);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.cBk == null) {
                        b.this.cBl.put(valueOf, obj);
                    } else {
                        d hA = b.this.hA(b.e.region_province);
                        if (hA != null) {
                            b.this.cBl.put("l1", hA);
                        }
                        d hA2 = b.this.hA(b.e.region_city);
                        if (hA2 != null) {
                            b.this.cBl.put("l2", hA2);
                        }
                        b.this.cBl.put("l3", b.this.hA(b.e.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.cBo.put(valueOf, true);
                    }
                    if (b.this.aqn() && b.this.aqo()) {
                        b.this.cBm.fj(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.cBo.put(valueOf, false);
                    b.this.cBm.fj(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqn() {
        for (Boolean bool : this.cBo.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqo() {
        for (Boolean bool : this.cBn.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hA(int i) {
        Object tag;
        if (this.cBk == null || (tag = this.cBk.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c {
        private View cBj;
        private TextView cBr;
        private EditText cBs;
        private ImageView cBt;
        private View cBu;

        public c(View view) {
            this.cBj = view;
            this.cBr = (TextView) view.findViewById(b.e.delivery_label);
            this.cBs = (EditText) view.findViewById(b.e.delivery_content);
            this.cBt = (ImageView) view.findViewById(b.e.delivery_arrow);
            this.cBu = view.findViewById(b.e.delivery_highlight_line);
        }
    }
}
