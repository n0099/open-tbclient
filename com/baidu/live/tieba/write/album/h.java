package com.baidu.live.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private c aWC;
    private f aWE;
    private g aWF;
    private AlbumActivity aWd;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aWD = false;

    public h(AlbumActivity albumActivity, c cVar) {
        this.aWd = albumActivity;
        this.aWC = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.aWd.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (!ListUtils.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dh */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) ListUtils.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.mDataList, i);
        if (mediaFileInfo != null) {
            return mediaFileInfo.getType();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MediaFileInfo item = getItem(i);
        if (item != null && item.getType() == 0) {
            return a(i, view, viewGroup, item);
        }
        return view;
    }

    private View a(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        b bVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = this.mLayoutInflater.inflate(a.h.sdk_ph_album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.aWI = (TbImageView) view.findViewById(a.g.pic);
                bVar2.aWI.setDefaultResource(0);
                bVar2.aWI.setDefaultErrorResource(0);
                bVar2.aWI.setTagPaddingDis(8, 8);
                bVar2.aWI.setGifIconSupport(true);
                bVar2.aWI.setLongIconSupport(true);
                bVar2.aWJ = (ImageView) view.findViewById(a.g.select_icon);
                bVar2.aWK = (RelativeLayout) view.findViewById(a.g.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.aWI.setIsLongPic(imageFileInfo.isLong());
            bVar.aWI.startLoad(TbImageView.getUrlWithResizeTag(imageFileInfo.getFilePath(), 200, 200), 35, false);
            a(bVar.aWJ, mediaFileInfo);
            a aVar = new a(mediaFileInfo, i);
            bVar.aWI.setOnClickListener(aVar);
            bVar.aWK.setOnClickListener(aVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.aWC != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.aWC.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.aWC != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.aWC.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.aWd.getResources().getString(a.i.sdk_ph_check_box_checked));
                SkinManager.setImageResource(imageView, a.f.sdk_ph_icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.aWd.getResources().getString(a.i.sdk_ph_check_box_not_checked));
            SkinManager.setImageResource(imageView, a.f.sdk_ph_icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private MediaFileInfo aWG;
        private int position;

        public a(MediaFileInfo mediaFileInfo, int i) {
            this.aWG = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.g.pic) {
                if (h.this.aWE != null && this.aWG != null) {
                    h.this.aWE.a(this.position, this.aWG);
                }
            } else if (view.getId() == a.g.lay_select && this.aWG != null && h.this.aWF != null) {
                h.this.aWF.b(this.position, this.aWG);
            }
        }
    }

    public boolean isScroll() {
        return this.aWD;
    }

    public void cb(boolean z) {
        this.aWD = z;
    }

    public void a(f fVar) {
        this.aWE = fVar;
    }

    public void a(g gVar) {
        this.aWF = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        TbImageView aWI;
        ImageView aWJ;
        RelativeLayout aWK;
        View rootView;

        private b() {
        }
    }

    public int e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        String filePath = imageFileInfo.getFilePath();
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            MediaFileInfo mediaFileInfo = this.mDataList.get(i);
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
