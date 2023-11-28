package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import com.baidu.tieba.op2;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {
    public ArrayList<MediaModel> a;
    public MediaModel b;
    public int c;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public SimpleDraweeView a;
        public View b;
        public View c;

        public a(SwanAppThumbnailAdapter swanAppThumbnailAdapter, View view2) {
            super(view2);
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0909a9);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0902a0);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f09029f);
        }
    }

    public SwanAppThumbnailAdapter(Context context) {
        this.c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070879);
    }

    public MediaModel l(int i) {
        ArrayList<MediaModel> arrayList = this.a;
        if (arrayList != null && i >= 0 && i < arrayList.size()) {
            return this.a.get(i);
        }
        return null;
    }

    public void r(ArrayList<MediaModel> arrayList) {
        this.a = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.b = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<MediaModel> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MediaModel> n() {
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(a aVar, int i) {
        int i2;
        ArrayList<MediaModel> arrayList = this.a;
        if (arrayList == null) {
            return;
        }
        MediaModel mediaModel = arrayList.get(i);
        aVar.a.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
        View view2 = aVar.b;
        int i3 = 8;
        if (mediaModel instanceof VideoModel) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        View view3 = aVar.c;
        if (mediaModel.equals(this.b)) {
            i3 = 0;
        }
        view3.setVisibility(i3);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(mediaModel.getPath())));
        int i4 = this.c;
        newBuilderWithSource.setResizeOptions(new ResizeOptions(i4, i4));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setOldController(aVar.a.getController()).setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).build();
        aVar.a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            op2.C().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d096e, viewGroup, false));
    }

    public int q(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.b;
        this.b = mediaModel;
        int size = arrayList.size();
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            if (mediaModel2 != null && mediaModel2.equals(this.a.get(i3))) {
                notifyItemChanged(i3);
                i++;
            }
            if (mediaModel != null && mediaModel.equals(this.a.get(i3))) {
                notifyItemChanged(i3);
                i++;
                i2 = i3;
            }
            if (i >= 2) {
                break;
            }
        }
        return i2;
    }
}
