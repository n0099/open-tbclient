package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private Activity cAc;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cAr;
    private int cAs;
    private String cuC;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.cAc = activity;
        this.cuC = str;
        this.cAr = arrayList;
        this.cAs = (int) (ah.dip2px(this.cAc, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cAr == null) {
            return 0;
        }
        return this.cAr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.cAr.size()) {
            return null;
        }
        return this.cAr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.cAc).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.cAc.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.cAr.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.iL());
            if (aVar3.cBi != null) {
                aVar.cAu.setText(im(aVar3.cBi.size()));
                if (aVar3.cBi.get(0) != null && !TextUtils.isEmpty(aVar3.cBi.get(0).getPath())) {
                    ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(aVar3.cBi.get(0).getPath())));
                    ab.c(new d(this.cAs, this.cAs));
                    ab.yk(true);
                    aVar.cAt.setController(com.facebook.drawee.a.a.c.dPw().xW(false).be(ab.dWA()).c(aVar.cAt.getController()).dQn());
                }
            }
        }
        return view;
    }

    private String im(int i) {
        return TextUtils.equals(this.cuC, "Image") ? this.cAc.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.cAc.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes8.dex */
    public class a {
        SimpleDraweeView cAt;
        TextView cAu;
        TextView titleTv;

        public a(View view) {
            this.cAt = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cAu = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
