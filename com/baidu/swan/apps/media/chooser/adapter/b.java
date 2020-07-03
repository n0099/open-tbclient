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
import com.baidu.swan.apps.aq.ag;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private Activity bdo;
    private String cqu;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cqv;
    private int cqw;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.bdo = activity;
        this.cqu = str;
        this.cqv = arrayList;
        this.cqw = (int) (ag.dip2px(this.bdo, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cqv == null) {
            return 0;
        }
        return this.cqv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.cqv.size()) {
            return null;
        }
        return this.cqv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bdo).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.bdo.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.cqv.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.hk());
            if (aVar3.crn != null) {
                aVar.cqy.setText(fY(aVar3.crn.size()));
                if (aVar3.crn.get(0) != null && !TextUtils.isEmpty(aVar3.crn.get(0).getPath())) {
                    ImageRequestBuilder ac = ImageRequestBuilder.ac(Uri.fromFile(new File(aVar3.crn.get(0).getPath())));
                    ac.c(new d(this.cqw, this.cqw));
                    ac.wM(true);
                    aVar.cqx.setController(com.facebook.drawee.a.a.c.dzW().wy(false).bc(ac.dHb()).c(aVar.cqx.getController()).dAN());
                }
            }
        }
        return view;
    }

    private String fY(int i) {
        return TextUtils.equals(this.cqu, "Image") ? this.bdo.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.bdo.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes11.dex */
    public class a {
        SimpleDraweeView cqx;
        TextView cqy;
        TextView titleTv;

        public a(View view) {
            this.cqx = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.cqy = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
