package com.baidu.swan.apps.r.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private String[] awN;
    private Context mContext;

    public a(Context context, @NonNull String[] strArr) {
        this.mContext = context;
        this.awN = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.awN.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.awN[i];
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
                View inflate = View.inflate(this.mContext, b.g.aiapps_keyboard_img_item, null);
                bVar = new C0129a();
                ((C0129a) bVar).awO = (ImageView) inflate.findViewById(b.f.delete_key_img_view);
                view2 = inflate;
            } else {
                View inflate2 = View.inflate(this.mContext, b.g.aiapps_keyboard_text_item, null);
                bVar = new b();
                ((b) bVar).awP = (TextView) inflate2.findViewById(b.f.key_text_view);
                if (i == 9) {
                    if (TextUtils.isEmpty(this.awN[9])) {
                        inflate2.setBackgroundColor(this.mContext.getResources().getColor(b.c.aiapps_keyboard_non_number_item_background_normal));
                        view2 = inflate2;
                    } else {
                        inflate2.setBackgroundResource(b.e.aiapps_keyboard_non_number_item_selector);
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
        if (i != 11) {
            ((b) tag).awP.setText(this.awN[i]);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private static final class b {
        private TextView awP;

        private b() {
        }
    }

    /* renamed from: com.baidu.swan.apps.r.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0129a {
        private ImageView awO;

        private C0129a() {
        }
    }
}
