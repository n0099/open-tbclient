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
    private Activity bIs;
    private String cRf;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cWS;
    private int cWT;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.bIs = activity;
        this.cRf = str;
        this.cWS = arrayList;
        this.cWT = (int) (ah.dip2px(this.bIs, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWS == null) {
            return 0;
        }
        return this.cWS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.cWS.size()) {
            return null;
        }
        return this.cWS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bIs).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.bIs.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.cWS.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.iN());
            if (aVar3.cXJ != null) {
                aVar.cWV.setText(je(aVar3.cXJ.size()));
                if (aVar3.cXJ.get(0) != null && !TextUtils.isEmpty(aVar3.cXJ.get(0).getPath())) {
                    ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(aVar3.cXJ.get(0).getPath())));
                    ad.c(new d(this.cWT, this.cWT));
                    ad.Ai(true);
                    aVar.cWU.setController(com.facebook.drawee.a.a.c.ehd().zU(false).bn(ad.eoj()).c(aVar.cWU.getController()).ehU());
                }
            }
        }
        return view;
    }

    private String je(int i) {
        return TextUtils.equals(this.cRf, "Image") ? this.bIs.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.bIs.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes10.dex */
    public class a {
        SimpleDraweeView cWU;
        TextView cWV;
        TextView titleTv;

        public a(View view) {
            this.cWU = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cWV = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
