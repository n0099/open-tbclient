package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static final String ahy = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String ahz = String.valueOf(2147483646);
    private MediaFileInfo ahA;
    private List<MediaFileInfo> ahB;
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
    public void m15do(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void uN() {
        this.count++;
    }

    public ImageFileInfo uO() {
        if (this.ahA instanceof ImageFileInfo) {
            return (ImageFileInfo) this.ahA;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.ahA = mediaFileInfo;
    }

    public MediaFileInfo uP() {
        return this.ahA;
    }

    public List<MediaFileInfo> uQ() {
        return this.ahB;
    }

    public void y(List<MediaFileInfo> list) {
        this.ahB = list;
    }
}
