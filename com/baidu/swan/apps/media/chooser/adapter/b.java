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
    private String clG;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> clH;
    private int clI;
    private Activity clq;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.clq = activity;
        this.clG = str;
        this.clH = arrayList;
        this.clI = (int) (ag.dip2px(this.clq, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.clH == null) {
            return 0;
        }
        return this.clH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.clH.size()) {
            return null;
        }
        return this.clH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.clq).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.clq.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.clH.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.gU());
            if (aVar3.cmz != null) {
                aVar.clK.setText(fL(aVar3.cmz.size()));
                if (aVar3.cmz.get(0) != null && !TextUtils.isEmpty(aVar3.cmz.get(0).getPath())) {
                    ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(aVar3.cmz.get(0).getPath())));
                    ab.c(new d(this.clI, this.clI));
                    ab.wo(true);
                    aVar.clJ.setController(com.facebook.drawee.a.a.c.dvf().wa(false).bb(ab.dCl()).c(aVar.clJ.getController()).dvW());
                }
            }
        }
        return view;
    }

    private String fL(int i) {
        return TextUtils.equals(this.clG, "Image") ? this.clq.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.clq.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes11.dex */
    public class a {
        SimpleDraweeView clJ;
        TextView clK;
        TextView titleTv;

        public a(View view) {
            this.clJ = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.clK = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
