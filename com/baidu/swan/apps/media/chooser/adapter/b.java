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
import com.baidu.swan.apps.aq.ai;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private Activity bdG;
    private int csA;
    private String csy;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> csz;

    public b(Activity activity, String str, ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        this.bdG = activity;
        this.csy = str;
        this.csz = arrayList;
        this.csA = (int) (ai.dip2px(this.bdG, 50.0f) / 2.0f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.csz == null) {
            return 0;
        }
        return this.csz.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.csz.size()) {
            return null;
        }
        return this.csz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bdG).inflate(a.g.swanapp_album_name_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.bdG.getResources().getDrawable(a.e.swanapp_album_name_item_selector));
        com.baidu.swan.apps.media.chooser.model.a aVar3 = this.csz.get(i);
        if (aVar3 != null) {
            aVar.titleTv.setText(aVar3.hk());
            if (aVar3.ctq != null) {
                aVar.csC.setText(gi(aVar3.ctq.size()));
                if (aVar3.ctq.get(0) != null && !TextUtils.isEmpty(aVar3.ctq.get(0).getPath())) {
                    ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(aVar3.ctq.get(0).getPath())));
                    ab.c(new d(this.csA, this.csA));
                    ab.xr(true);
                    aVar.csB.setController(com.facebook.drawee.a.a.c.dDm().xd(false).bc(ab.dKr()).c(aVar.csB.getController()).dEd());
                }
            }
        }
        return view;
    }

    private String gi(int i) {
        return TextUtils.equals(this.csy, "Image") ? this.bdG.getString(a.h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.bdG.getString(a.h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    /* loaded from: classes7.dex */
    public class a {
        SimpleDraweeView csB;
        TextView csC;
        TextView titleTv;

        public a(View view) {
            this.csB = (SimpleDraweeView) view.findViewById(a.f.album_name_item_img);
            this.titleTv = (TextView) view.findViewById(a.f.album_name_item_title);
            this.csC = (TextView) view.findViewById(a.f.album_name_item_number);
        }
    }
}
