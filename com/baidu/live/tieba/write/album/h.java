package com.baidu.live.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends BaseAdapter {
    private c axG;
    private f axI;
    private g axJ;
    private AlbumActivity axh;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean axH = false;

    public h(AlbumActivity albumActivity, c cVar) {
        this.axh = albumActivity;
        this.axG = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.axh.getPageContext().getPageActivity());
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
    /* renamed from: cB */
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
                bVar2.axM = (TbImageView) view.findViewById(a.g.pic);
                bVar2.axM.setDefaultResource(0);
                bVar2.axM.setDefaultErrorResource(0);
                bVar2.axM.setTagPaddingDis(8, 8);
                bVar2.axM.setGifIconSupport(true);
                bVar2.axM.setLongIconSupport(true);
                bVar2.axN = (ImageView) view.findViewById(a.g.select_icon);
                bVar2.axO = (RelativeLayout) view.findViewById(a.g.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.axM.setIsLongPic(imageFileInfo.isLong());
            bVar.axM.startLoad(TbImageView.getUrlWithResizeTag(imageFileInfo.getFilePath(), 200, 200), 35, false);
            a(bVar.axN, mediaFileInfo);
            a aVar = new a(mediaFileInfo, i);
            bVar.axM.setOnClickListener(aVar);
            bVar.axO.setOnClickListener(aVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.axG != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.axG.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.axG != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.axG.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.axh.getResources().getString(a.i.sdk_ph_check_box_checked));
                SkinManager.setImageResource(imageView, a.f.sdk_ph_icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.axh.getResources().getString(a.i.sdk_ph_check_box_not_checked));
            SkinManager.setImageResource(imageView, a.f.sdk_ph_icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        private MediaFileInfo axK;
        private int position;

        public a(MediaFileInfo mediaFileInfo, int i) {
            this.axK = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.g.pic) {
                if (h.this.axI != null && this.axK != null) {
                    h.this.axI.a(this.position, this.axK);
                }
            } else if (view.getId() == a.g.lay_select && this.axK != null && h.this.axJ != null) {
                h.this.axJ.b(this.position, this.axK);
            }
        }
    }

    public boolean isScroll() {
        return this.axH;
    }

    public void bk(boolean z) {
        this.axH = z;
    }

    public void a(f fVar) {
        this.axI = fVar;
    }

    public void a(g gVar) {
        this.axJ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        TbImageView axM;
        ImageView axN;
        RelativeLayout axO;
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
