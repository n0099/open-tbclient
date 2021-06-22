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
import d.a.m0.a.d;
import d.a.m0.a.f;
import d.a.m0.a.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f11054a;

    /* renamed from: b  reason: collision with root package name */
    public MediaModel f11055b;

    /* renamed from: c  reason: collision with root package name */
    public int f11056c;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f11057a;

        /* renamed from: b  reason: collision with root package name */
        public View f11058b;

        /* renamed from: c  reason: collision with root package name */
        public View f11059c;

        public a(SwanAppThumbnailAdapter swanAppThumbnailAdapter, View view) {
            super(view);
            this.f11057a = (SimpleDraweeView) view.findViewById(f.drag_photo_view);
            this.f11058b = view.findViewById(f.album_thumbnail_video);
            this.f11059c = view.findViewById(f.album_thumbnail_selected);
        }
    }

    public SwanAppThumbnailAdapter(Context context) {
        this.f11056c = context.getResources().getDimensionPixelSize(d.swanapp_preview_thumbnail);
    }

    public MediaModel g(int i2) {
        ArrayList<MediaModel> arrayList = this.f11054a;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f11054a.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<MediaModel> arrayList = this.f11054a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MediaModel> m() {
        return this.f11054a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(a aVar, int i2) {
        ArrayList<MediaModel> arrayList = this.f11054a;
        if (arrayList == null) {
            return;
        }
        MediaModel mediaModel = arrayList.get(i2);
        aVar.f11057a.setImageURI(Uri.fromFile(new File(mediaModel.b())));
        aVar.f11058b.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
        aVar.f11059c.setVisibility(mediaModel.equals(this.f11055b) ? 0 : 8);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(mediaModel.b())));
        int i3 = this.f11056c;
        newBuilderWithSource.setResizeOptions(new ResizeOptions(i3, i3));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setOldController(aVar.f11057a.getController()).setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).build();
        aVar.f11057a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            d.a.m0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g.swanapp_thumbnail_drag_item, viewGroup, false));
    }

    public int p(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = this.f11054a;
        if (arrayList == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.f11055b;
        this.f11055b = mediaModel;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            if (mediaModel2 != null && mediaModel2.equals(this.f11054a.get(i4))) {
                notifyItemChanged(i4);
                i2++;
            }
            if (mediaModel != null && mediaModel.equals(this.f11054a.get(i4))) {
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

    public void q(ArrayList<MediaModel> arrayList) {
        this.f11054a = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.f11055b = arrayList.get(0);
        }
        notifyDataSetChanged();
    }
}
