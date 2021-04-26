package com.baidu.livesdk.api.im.live;
/* loaded from: classes2.dex */
public class ImageAudioMsg {
    public static final int IM_MSG_TYPE_AUDIO = 1;
    public static final int IM_MSG_TYPE_IMG = 0;
    public static final int SUCCESS = 0;
    public int audioDuration;
    public int heigth;
    public int thumbHeigth;
    public String thumbUrl;
    public int thurbWidth;
    public int type;
    public String url;
    public int width;

    public int getAudioDuration() {
        return this.audioDuration;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public int getThumbHeigth() {
        return this.thumbHeigth;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public int getThurbWidth() {
        return this.thurbWidth;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAudioDuration(int i2) {
        this.audioDuration = i2;
    }

    public void setHeigth(int i2) {
        this.heigth = i2;
    }

    public void setThumbHeigth(int i2) {
        this.thumbHeigth = i2;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setThurbWidth(int i2) {
        this.thurbWidth = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
