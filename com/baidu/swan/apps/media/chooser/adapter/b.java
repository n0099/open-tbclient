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
    private Activity caH;
    private String caX;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> caY;
    private int caZ;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.caH = activity;
        this.caX = str;
        this.caY = arrayList;
        this.caZ = (int) (af.dip2px(this.caH, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.caY == null) {
            return 0;
        }
        return this.caY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.caY.size()) {
            return null;
        }
        return this.caY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.caH).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.caH.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.caY.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.gU());
            if (aVar3.cbP != null) {
                aVar.cbb.setText(fx(aVar3.cbP.size()));
                if (aVar3.cbP.get(0) != null && !TextUtils.isEmpty(aVar3.cbP.get(0).getPath())) {
                    ImageRequestBuilder Z = ImageRequestBuilder.Z(Uri.fromFile(new File(aVar3.cbP.get(0).getPath())));
                    Z.c(new d(this.caZ, this.caZ));
                    Z.vQ(true);
                    aVar.cba.setController(com.facebook.drawee.a.a.c.dnP().vC(false).aW(Z.duW()).c(aVar.cba.getController()).doG());
                }
            }
        }
        return view;
    }

    private String fx(int i) {
        return TextUtils.equals(this.caX, "Image") ? this.caH.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.caH.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes11.dex */
    public class a {
        SimpleDraweeView cba;
        TextView cbb;
        TextView titleTv;

        public a(View view) {
            this.cba = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cbb = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
