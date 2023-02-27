package com.baidu.live.mix.creator;

import com.baidu.live.mix.creator.MixLiveCreatorInterface;
import com.baidu.pyramid.annotation.Autowired;
import kotlin.Metadata;
@Autowired
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b$\u0010%R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveShellCreateHelper;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "audioLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "getAudioLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "setAudioLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "consultLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "getConsultLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "setConsultLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "mediaLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "getMediaLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "setMediaLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "newMediaLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "getNewMediaLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "setNewMediaLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;)V", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "shoppingLiveCreator", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "getShoppingLiveCreator", "()Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "setShoppingLiveCreator", "(Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;)V", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixLiveShellCreateHelper {
    public static final MixLiveShellCreateHelper INSTANCE = new MixLiveShellCreateHelper();
    public static MixLiveCreatorInterface.MediaLiveCreator mediaLiveCreator = new MixLiveCreatorInterface.MediaEmpty();
    public static MixLiveCreatorInterface.NewMediaLiveCreator newMediaLiveCreator = new MixLiveCreatorInterface.NewMediaEmpty();
    public static MixLiveCreatorInterface.ShoppingLiveCreator shoppingLiveCreator = new MixLiveCreatorInterface.ShoppingEmpty();
    public static MixLiveCreatorInterface.ConsultLiveCreator consultLiveCreator = new MixLiveCreatorInterface.ConsultEmpty();
    public static MixLiveCreatorInterface.AudioLiveCreator audioLiveCreator = new MixLiveCreatorInterface.AudioEmpty();

    public final MixLiveCreatorInterface.AudioLiveCreator getAudioLiveCreator() {
        return audioLiveCreator;
    }

    public final MixLiveCreatorInterface.ConsultLiveCreator getConsultLiveCreator() {
        return consultLiveCreator;
    }

    public final MixLiveCreatorInterface.MediaLiveCreator getMediaLiveCreator() {
        return mediaLiveCreator;
    }

    public final MixLiveCreatorInterface.NewMediaLiveCreator getNewMediaLiveCreator() {
        return newMediaLiveCreator;
    }

    public final MixLiveCreatorInterface.ShoppingLiveCreator getShoppingLiveCreator() {
        return shoppingLiveCreator;
    }

    public final void setAudioLiveCreator(MixLiveCreatorInterface.AudioLiveCreator audioLiveCreator2) {
        audioLiveCreator = audioLiveCreator2;
    }

    public final void setConsultLiveCreator(MixLiveCreatorInterface.ConsultLiveCreator consultLiveCreator2) {
        consultLiveCreator = consultLiveCreator2;
    }

    public final void setMediaLiveCreator(MixLiveCreatorInterface.MediaLiveCreator mediaLiveCreator2) {
        mediaLiveCreator = mediaLiveCreator2;
    }

    public final void setNewMediaLiveCreator(MixLiveCreatorInterface.NewMediaLiveCreator newMediaLiveCreator2) {
        newMediaLiveCreator = newMediaLiveCreator2;
    }

    public final void setShoppingLiveCreator(MixLiveCreatorInterface.ShoppingLiveCreator shoppingLiveCreator2) {
        shoppingLiveCreator = shoppingLiveCreator2;
    }
}
