package com.baidu.platform.comapi.walknavi.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.a.c;
import com.baidu.platform.comapi.wnplatform.p.e;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends c {
    public int a;
    public String b;
    private String h;

    public b(ArrayList<String> arrayList) {
        super(arrayList);
        this.a = -1;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private int b;

        public a(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a) && ((c.a) tag) != null) {
                String str = "";
                if (b.this.getItem(this.b) != null) {
                    str = b.this.getItem(this.b);
                }
                b.this.b = str;
                b.this.h = "";
                b.this.a = this.b;
                e.a(str, b.this.f, true);
                b.this.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c.a aVar;
        String a2 = getItem(i);
        if (a2 == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.mipmap.ufo_add_pic_icon, null);
            view.setClickable(false);
            c.a aVar2 = new c.a();
            aVar2.c = (TextView) view.findViewById(R.xml.null_network_security_config);
            aVar2.a = view.findViewById(R.xml.nfc_tech_filter);
            aVar2.b = (ImageView) view.findViewById(R.xml.pass_sdk_file_provider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (c.a) view.getTag();
        }
        a(i, view, aVar);
        aVar.d = null;
        aVar.e = null;
        aVar.a.setTag(aVar);
        aVar.a.setOnClickListener(new a(i));
        aVar.c.setText(a2);
        a(a2, aVar, i);
        return view;
    }

    private void a(String str, c.a aVar, int i) {
        a(aVar);
        b(str, aVar, i);
    }

    public void a(c.a aVar) {
        if (!this.e) {
            aVar.c.setTextSize(1, 9.0f);
        }
    }

    public void a(String str) {
        this.h = str;
    }

    @TargetApi(16)
    private void b(String str, c.a aVar, int i) {
        if (this.a == i) {
            if (getCount() == 1) {
                aVar.a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, (int) R.drawable.aiapps_favorite_guide_bg));
            } else if (i == 0) {
                if (this.e) {
                    aVar.a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, (int) R.drawable.aiapps_favorite_guide_close_selector));
                } else {
                    aVar.a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, (int) R.drawable.aiapps_float_view_button_shape));
                }
            } else if (i == getCount() - 1) {
                if (this.e) {
                    aVar.a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, (int) R.drawable.aiapps_favorite_guide_close_selector));
                } else {
                    aVar.a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, (int) R.drawable.aiapps_favorite_guide_checkbox_selected));
                }
            } else {
                aVar.a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, (int) R.drawable.aiapps_favorite_guide_close_selector));
            }
            aVar.c.setTextColor(-1);
            this.b = getItem(this.a);
            return;
        }
        aVar.c.setTextColor(-13488081);
    }

    public int a() {
        String str = this.h;
        for (int i = 0; i < getCount(); i++) {
            if (TextUtils.equals(str, getItem(i))) {
                this.a = i;
            }
        }
        return this.a;
    }
}
