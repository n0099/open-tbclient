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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private Activity bFt;
    private String cIJ;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cOw;
    private int cOx;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.bFt = activity;
        this.cIJ = str;
        this.cOw = arrayList;
        this.cOx = (int) (ah.dip2px(this.bFt, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cOw == null) {
            return 0;
        }
        return this.cOw.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.cOw.size()) {
            return null;
        }
        return this.cOw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bFt).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.bFt.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.cOw.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.iN());
            if (aVar3.cPn != null) {
                aVar.cOz.setText(iT(aVar3.cPn.size()));
                if (aVar3.cPn.get(0) != null && !TextUtils.isEmpty(aVar3.cPn.get(0).getPath())) {
                    ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(aVar3.cPn.get(0).getPath())));
                    ad.c(new d(this.cOx, this.cOx));
                    ad.za(true);
                    aVar.cOy.setController(com.facebook.drawee.a.a.c.dXf().yM(false).bj(ad.eej()).c(aVar.cOy.getController()).dXW());
                }
            }
        }
        return view;
    }

    private String iT(int i) {
        return TextUtils.equals(this.cIJ, "Image") ? this.bFt.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.bFt.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes10.dex */
    public class a {
        SimpleDraweeView cOy;
        TextView cOz;
        TextView titleTv;

        public a(View view) {
            this.cOy = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cOz = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
