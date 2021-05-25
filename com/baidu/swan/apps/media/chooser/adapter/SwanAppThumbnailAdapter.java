package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.l0.a.d;
import d.a.l0.a.f;
import d.a.l0.a.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f10910a;

    /* renamed from: b  reason: collision with root package name */
    public MediaModel f10911b;

    /* renamed from: c  reason: collision with root package name */
    public int f10912c;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f10913a;

        /* renamed from: b  reason: collision with root package name */
        public View f10914b;

        /* renamed from: c  reason: collision with root package name */
        public View f10915c;

        public a(SwanAppThumbnailAdapter swanAppThumbnailAdapter, View view) {
            super(view);
            this.f10913a = (SimpleDraweeView) view.findViewById(f.drag_photo_view);
            this.f10914b = view.findViewById(f.album_thumbnail_video);
            this.f10915c = view.findViewById(f.album_thumbnail_selected);
        }
    }

    public SwanAppThumbnailAdapter(Context context) {
        this.f10912c = context.getResources().getDimensionPixelSize(d.swanapp_preview_thumbnail);
    }

    public MediaModel c(int i2) {
        ArrayList<MediaModel> arrayList = this.f10910a;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f10910a.get(i2);
    }

    public ArrayList<MediaModel> d() {
        return this.f10910a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(a aVar, int i2) {
        ArrayList<MediaModel> arrayList = this.f10910a;
        if (arrayList == null) {
            return;
        }
        MediaModel mediaModel = arrayList.get(i2);
        aVar.f10913a.setImageURI(Uri.fromFile(new File(mediaModel.b())));
        aVar.f10914b.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
        aVar.f10915c.setVisibility(mediaModel.equals(this.f10911b) ? 0 : 8);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(mediaModel.b())));
        int i3 = this.f10912c;
        newBuilderWithSource.setResizeOptions(new ResizeOptions(i3, i3));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setOldController(aVar.f10913a.getController()).setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).build();
        aVar.f10913a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            d.a.l0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g.swanapp_thumbnail_drag_item, viewGroup, false));
    }

    public int g(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = this.f10910a;
        if (arrayList == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.f10911b;
        this.f10911b = mediaModel;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            if (mediaModel2 != null && mediaModel2.equals(this.f10910a.get(i4))) {
                notifyItemChanged(i4);
                i2++;
            }
            if (mediaModel != null && mediaModel.equals(this.f10910a.get(i4))) {
                notifyItemChanged(i4);
                i2++;
                i3 = i4;
            }
            if (i2 >= 2) {
                break;
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<MediaModel> arrayList = this.f10910a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void h(ArrayList<MediaModel> arrayList) {
        this.f10910a = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.f10911b = arrayList.get(0);
        }
        notifyDataSetChanged();
    }
}
