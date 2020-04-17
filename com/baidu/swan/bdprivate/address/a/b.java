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
public class b extends BaseAdapter implements a.InterfaceC0347a {
    private EditText cBe;
    private a cBg;
    private Context mContext;
    private List<com.baidu.swan.bdprivate.address.c.a> mDataList;
    private Map<String, Object> cBf = new HashMap();
    private Map<String, Boolean> cBh = new HashMap(5);
    private Map<String, Boolean> cBi = new HashMap(4);

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
        this.cBi = map;
    }

    public void q(Map<String, Boolean> map) {
        this.cBh = map;
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
        this.cBg = aVar;
    }

    public boolean aqe() {
        return aqp();
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
        TextView textView = cVar.cBl;
        EditText editText = cVar.cBm;
        ImageView imageView = cVar.cBn;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.cBw) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0345b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.swan.bdprivate.address.view.a aVar = new com.baidu.swan.bdprivate.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aqI();
                }
            });
            this.cBe = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
            return;
        }
        cVar.cBd.setBackgroundColor(Color.parseColor("#191919"));
        cVar.cBl.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.cBm.setTextColor(Color.parseColor("#666666"));
        cVar.cBm.setHintTextColor(Color.parseColor("#333333"));
        cVar.cBo.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.swan.bdprivate.address.view.a.InterfaceC0347a
    public void al(List<d> list) {
        if (list != null && list.size() == 3 && this.cBe != null) {
            this.cBe.setTag(b.e.region_province, list.get(0));
            this.cBe.setTag(b.e.region_city, list.get(1));
            this.cBe.setTag(b.e.region_county, list.get(2));
            this.cBe.setText(d.an(list));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cBf;
    }

    /* renamed from: com.baidu.swan.bdprivate.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0345b implements TextWatcher {
        private String cBk;
        private EditText mEditText;

        public C0345b(EditText editText) {
            this.mEditText = editText;
            this.cBk = this.mEditText.getText().toString();
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
                if (editable == null || !TextUtils.equals(editable.toString(), this.cBk)) {
                    b.this.cBh.put(valueOf, true);
                } else {
                    b.this.cBh.put(valueOf, false);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.cBe == null) {
                        b.this.cBf.put(valueOf, obj);
                    } else {
                        d hA = b.this.hA(b.e.region_province);
                        if (hA != null) {
                            b.this.cBf.put("l1", hA);
                        }
                        d hA2 = b.this.hA(b.e.region_city);
                        if (hA2 != null) {
                            b.this.cBf.put("l2", hA2);
                        }
                        b.this.cBf.put("l3", b.this.hA(b.e.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.cBi.put(valueOf, true);
                    }
                    if (b.this.aqo() && b.this.aqp()) {
                        b.this.cBg.fj(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.cBi.put(valueOf, false);
                    b.this.cBg.fj(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqo() {
        for (Boolean bool : this.cBi.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqp() {
        for (Boolean bool : this.cBh.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hA(int i) {
        Object tag;
        if (this.cBe == null || (tag = this.cBe.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c {
        private View cBd;
        private TextView cBl;
        private EditText cBm;
        private ImageView cBn;
        private View cBo;

        public c(View view) {
            this.cBd = view;
            this.cBl = (TextView) view.findViewById(b.e.delivery_label);
            this.cBm = (EditText) view.findViewById(b.e.delivery_content);
            this.cBn = (ImageView) view.findViewById(b.e.delivery_arrow);
            this.cBo = view.findViewById(b.e.delivery_highlight_line);
        }
    }
}
