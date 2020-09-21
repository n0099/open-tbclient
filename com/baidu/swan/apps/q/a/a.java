package com.baidu.swan.apps.q.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private String[] cvK;
    private Context mContext;

    public a(Context context, @NonNull String[] strArr) {
        this.mContext = context;
        this.cvK = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cvK.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cvK[i];
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
                bVar = new C0419a();
                ((C0419a) bVar).cvL = (ImageView) inflate.findViewById(a.f.delete_key_img_view);
                view2 = inflate;
            } else {
                View inflate2 = View.inflate(this.mContext, a.g.aiapps_keyboard_text_item, null);
                bVar = new b();
                ((b) bVar).cvM = (TextView) inflate2.findViewById(a.f.key_text_view);
                if (i == 9) {
                    if (TextUtils.isEmpty(this.cvK[9])) {
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
            ((b) tag).cvM.setText(this.cvK[i]);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static final class b {
        private TextView cvM;

        private b() {
        }
    }

    /* renamed from: com.baidu.swan.apps.q.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0419a {
        private ImageView cvL;

        private C0419a() {
        }
    }
}
