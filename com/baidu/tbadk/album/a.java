package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static final String ail = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String aim = String.valueOf(2147483646);
    private MediaFileInfo ain;
    private List<MediaFileInfo> aio;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void dn(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getCount() {
        return this.count;
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void uX() {
        this.count++;
    }

    public ImageFileInfo uY() {
        if (this.ain instanceof ImageFileInfo) {
            return (ImageFileInfo) this.ain;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.ain = mediaFileInfo;
    }

    public MediaFileInfo uZ() {
        return this.ain;
    }

    public List<MediaFileInfo> va() {
        return this.aio;
    }

    public void x(List<MediaFileInfo> list) {
        this.aio = list;
    }
}
