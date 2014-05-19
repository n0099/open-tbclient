package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class ResourceUtil {
    private final String TAG = "ResourceUtil";
    Context context;
    DrawableStyle cyberButton;
    String pkgName;
    Resources res;

    public ResourceUtil(String str, Resources resources, Context context) {
        this.pkgName = str;
        this.res = resources;
        this.cyberButton = new DrawableStyle(context);
    }

    public int getColorId(String str) {
        return this.res.getIdentifier(str, "color", this.pkgName);
    }

    public Drawable getDrawable(String str) {
        return this.res.getDrawable(getDrawableId(str));
    }

    public int getDrawableId(String str) {
        return this.res.getIdentifier(str, "drawable", this.pkgName);
    }

    public int getId(String str) {
        return this.res.getIdentifier(str, "id", this.pkgName);
    }

    public StateListDrawable getLastButtonStyle() {
        return this.cyberButton.getStateListDrawable(this.res.getDrawable(getDrawableId("cyberplayer_next_play")), this.res.getDrawable(getDrawableId("cyberplayer_next_play_disable")), this.res.getDrawable(getDrawableId("cyberplayer_next_play_pressed")));
    }

    public int getLayoutId(String str) {
        return this.res.getIdentifier(str, "layout", this.pkgName);
    }

    public StateListDrawable getPauseButtonSytle() {
        return this.cyberButton.getStateListDrawable(this.res.getDrawable(getDrawableId("cyberplayer_stop_media")), this.res.getDrawable(getDrawableId("cyberplayer_stop_media_disable")), this.res.getDrawable(getDrawableId("cyberplayer_stop_media_pressed")));
    }

    public StateListDrawable getPlayButtonStyle() {
        return this.cyberButton.getStateListDrawable(this.res.getDrawable(getDrawableId("cyberplayer_play_media")), this.res.getDrawable(getDrawableId("cyberplayer_play_media_disable")), this.res.getDrawable(getDrawableId("cyberplayer_play_media_pressed")));
    }

    public StateListDrawable getPreButtonStyle() {
        return this.cyberButton.getStateListDrawable(this.res.getDrawable(getDrawableId("cyberplayer_retreat_media")), this.res.getDrawable(getDrawableId("cyberplayer_retreat_media_disable")), this.res.getDrawable(getDrawableId("cyberplayer_retreat_media_pressed")));
    }

    public LayerDrawable getProgressLayer(ProgressBar progressBar) {
        LayerDrawable layerDrawable = (LayerDrawable) progressBar.getProgressDrawable();
        ClipDrawable clipDrawable = new ClipDrawable(this.res.getDrawable(getDrawableId("cyberplayer_seekbar_cache")), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(this.res.getDrawable(getDrawableId("cyberplayer_seekbar_normal")), 3, 1);
        layerDrawable.setDrawableByLayerId(16908288, this.res.getDrawable(getDrawableId("cyberplayer_seekbar_background")));
        layerDrawable.setDrawableByLayerId(16908303, clipDrawable);
        layerDrawable.setDrawableByLayerId(16908301, clipDrawable2);
        return layerDrawable;
    }

    public int getStringId(String str) {
        return this.res.getIdentifier(str, "string", this.pkgName);
    }

    public int getStyleId(String str) {
        return this.res.getIdentifier(str, "style", this.pkgName);
    }
}
