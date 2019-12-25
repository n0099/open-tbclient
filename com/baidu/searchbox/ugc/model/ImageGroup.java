package com.baidu.searchbox.ugc.model;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class ImageGroup implements Comparable<Object> {
    public static final String ALL_IMAGE_BUCKET_ID = String.valueOf(Integer.MIN_VALUE);
    private String bucketID;
    private String bucketName = "";
    public List<ImageStruct> images = new ArrayList();
    private long lastModified;

    public String getBucketID() {
        return this.bucketID;
    }

    public void setBucketID(String str) {
        this.bucketID = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setImages(List<ImageStruct> list) {
        this.images = list;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public ImageStruct getFirstImgInfo() {
        if (this.images.size() > 0) {
            return this.images.get(0);
        }
        return null;
    }

    public int getImageCount() {
        return this.images.size();
    }

    public List<ImageStruct> getImages() {
        return this.images;
    }

    public void addImage(ImageStruct imageStruct) {
        if (this.images == null) {
            this.images = new ArrayList();
        }
        if (imageStruct != null) {
            if (this.lastModified < imageStruct.dateModified) {
                this.lastModified = imageStruct.dateModified;
            }
            this.images.add(imageStruct);
        }
    }

    public String toString() {
        return "ImageGroup{bucketID=" + this.bucketID + ", bucketName='" + this.bucketName + "', lastModified=" + this.lastModified + ", images=" + this.images + '}';
    }

    public boolean equals(Object obj) {
        return (obj instanceof ImageGroup) && this.bucketID == ((ImageGroup) obj).bucketID;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((ImageGroup) obj).getLastModified()).compareTo(Long.valueOf(this.lastModified));
    }
}
