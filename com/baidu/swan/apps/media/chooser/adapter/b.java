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
import com.baidu.swan.apps.as.af;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private Activity caN;
    private String cbd;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cbe;
    private int cbf;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.caN = activity;
        this.cbd = str;
        this.cbe = arrayList;
        this.cbf = (int) (af.dip2px(this.caN, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cbe == null) {
            return 0;
        }
        return this.cbe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.cbe.size()) {
            return null;
        }
        return this.cbe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.caN).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.caN.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.cbe.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.gU());
            if (aVar3.cbV != null) {
                aVar.cbh.setText(fx(aVar3.cbV.size()));
                if (aVar3.cbV.get(0) != null && !TextUtils.isEmpty(aVar3.cbV.get(0).getPath())) {
                    ImageRequestBuilder Z = ImageRequestBuilder.Z(Uri.fromFile(new File(aVar3.cbV.get(0).getPath())));
                    Z.c(new d(this.cbf, this.cbf));
                    Z.vQ(true);
                    aVar.cbg.setController(com.facebook.drawee.a.a.c.dnN().vC(false).aX(Z.duU()).c(aVar.cbg.getController()).doE());
                }
            }
        }
        return view;
    }

    private String fx(int i) {
        return TextUtils.equals(this.cbd, "Image") ? this.caN.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.caN.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes11.dex */
    public class a {
        SimpleDraweeView cbg;
        TextView cbh;
        TextView titleTv;

        public a(View view) {
            this.cbg = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cbh = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
