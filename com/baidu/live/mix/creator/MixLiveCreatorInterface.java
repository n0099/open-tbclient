package com.baidu.live.mix.creator;

import android.content.Context;
import com.baidu.live.mix.interfaces.MixLiveInterface;
import com.baidu.live.mix.interfaces.MixLiveSingletonManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001:\f\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "AudioEmpty", "AudioLiveCreator", "ConsultEmpty", "ConsultLiveCreator", "MediaEmpty", "MediaLiveCreator", "NewMediaEmpty", "NewMediaLiveCreator", "ShoppingEmpty", "ShoppingLiveCreator", "YYEmpty", "YYLiveCreator", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixLiveCreatorInterface {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioEmpty;", "com/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class AudioEmpty implements AudioLiveCreator {
        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveInterface> createMixLiveImpl() {
            return null;
        }

        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$AudioLiveCreator;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface AudioLiveCreator extends MixLiveCreatorInterface {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultEmpty;", "com/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class ConsultEmpty implements ConsultLiveCreator {
        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveInterface> createMixLiveImpl() {
            return null;
        }

        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ConsultLiveCreator;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ConsultLiveCreator extends MixLiveCreatorInterface {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaEmpty;", "com/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class MediaEmpty implements MediaLiveCreator {
        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveInterface> createMixLiveImpl() {
            return null;
        }

        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$MediaLiveCreator;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface MediaLiveCreator extends MixLiveCreatorInterface {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaEmpty;", "com/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class NewMediaEmpty implements NewMediaLiveCreator {
        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveInterface> createMixLiveImpl() {
            return null;
        }

        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$NewMediaLiveCreator;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface NewMediaLiveCreator extends MixLiveCreatorInterface {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingEmpty;", "com/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class ShoppingEmpty implements ShoppingLiveCreator {
        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveInterface> createMixLiveImpl() {
            return null;
        }

        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$ShoppingLiveCreator;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ShoppingLiveCreator extends MixLiveCreatorInterface {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$YYEmpty;", "com/baidu/live/mix/creator/MixLiveCreatorInterface$YYLiveCreator", "Lkotlin/Function0;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "createMixLiveImpl", "()Lkotlin/Function0;", "Landroid/content/Context;", "context", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "createMixLiveSingletonManagerImpl", "(Landroid/content/Context;)Lkotlin/Function0;", "<init>", "()V", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class YYEmpty implements YYLiveCreator {
        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveInterface> createMixLiveImpl() {
            return null;
        }

        @Override // com.baidu.live.mix.creator.MixLiveCreatorInterface
        public Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/live/mix/creator/MixLiveCreatorInterface$YYLiveCreator;", "Lcom/baidu/live/mix/creator/MixLiveCreatorInterface;", "Lkotlin/Any;", "lib-live-mix-creator_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface YYLiveCreator extends MixLiveCreatorInterface {
    }

    Function0<MixLiveInterface> createMixLiveImpl();

    Function0<MixLiveSingletonManagerInterface> createMixLiveSingletonManagerImpl(Context context);
}
