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
    private String bCC;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> bCD;
    private int bCE;
    private Activity mContext;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.mContext = activity;
        this.bCC = str;
        this.bCD = arrayList;
        this.bCE = (int) (af.dip2px(this.mContext, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bCD == null) {
            return 0;
        }
        return this.bCD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.bCD.size()) {
            return null;
        }
        return this.bCD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.mContext.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.bCD.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.bx());
            if (aVar3.bDr != null) {
                aVar.bCG.setText(fq(aVar3.bDr.size()));
                if (aVar3.bDr.get(0) != null && !TextUtils.isEmpty(aVar3.bDr.get(0).getPath())) {
                    ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(aVar3.bDr.get(0).getPath())));
                    Y.c(new d(this.bCE, this.bCE));
                    Y.vD(true);
                    aVar.bCF.setController(com.facebook.drawee.a.a.c.dlW().vo(false).bg(Y.dta()).c(aVar.bCF.getController()).dmN());
                }
            }
        }
        return view;
    }

    private String fq(int i) {
        return TextUtils.equals(this.bCC, "Image") ? this.mContext.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.mContext.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes11.dex */
    public class a {
        SimpleDraweeView bCF;
        TextView bCG;
        TextView titleTv;

        public a(View view) {
            this.bCF = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.bCG = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
