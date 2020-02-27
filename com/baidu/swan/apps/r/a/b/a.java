package com.baidu.swan.apps.r.a.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String[] bwL;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, @NonNull String[] strArr) {
        this.mContext = context;
        this.bwL = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bwL.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bwL[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Object tag;
        Object bVar;
        View view2;
        if (view == null) {
            if (i == 11) {
                View inflate = View.inflate(this.mContext, a.g.aiapps_keyboard_img_item, null);
                bVar = new C0275a();
                ((C0275a) bVar).bwM = (ImageView) inflate.findViewById(a.f.delete_key_img_view);
                view2 = inflate;
            } else {
                View inflate2 = View.inflate(this.mContext, a.g.aiapps_keyboard_text_item, null);
                bVar = new b();
                ((b) bVar).bwN = (TextView) inflate2.findViewById(a.f.key_text_view);
                if (i == 9) {
                    if (TextUtils.isEmpty(this.bwL[9])) {
                        inflate2.setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_keyboard_non_number_item_background_normal));
                        view2 = inflate2;
                    } else {
                        inflate2.setBackgroundResource(a.e.aiapps_keyboard_non_number_item_selector);
                    }
                }
                view2 = inflate2;
            }
            view2.setTag(bVar);
            view = view2;
            tag = bVar;
        } else {
            tag = view.getTag();
        }
        if (i != 11 && (tag instanceof b)) {
            ((b) tag).bwN.setText(this.bwL[i]);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private static final class b {
        private TextView bwN;

        private b() {
        }
    }

    /* renamed from: com.baidu.swan.apps.r.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static final class C0275a {
        private ImageView bwM;

        private C0275a() {
        }
    }
}
