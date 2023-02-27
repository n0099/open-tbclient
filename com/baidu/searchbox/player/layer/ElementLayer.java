package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class ElementLayer<T extends ViewGroup, S extends AbsElement> extends AbsLayer implements View.OnClickListener {
    public T mContainer;
    public final ArrayList<S> mElements;

    public abstract void initContainer();

    public void layoutElement(@NonNull T t) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public abstract void setupElement();

    public ElementLayer() {
        this.mElements = new ArrayList<>();
    }

    @PublicMethod
    public ArrayList<S> getElements() {
        return this.mElements;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{4, 5, 2, 3, 1};
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        initContainer();
        setupElement();
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            S next = it.next();
            next.setParent(this);
            next.initElement();
            if (next.attachToRootAtOnce()) {
                attachElementView(next);
            }
        }
        layoutElement(this.mContainer);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
        super.onContainerDetach();
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            it.next().onContainerDetach();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        super.onLayerDetach();
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            it.next().onLayerDetach();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        super.onLayerRelease();
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            it.next().onLayerRelease();
        }
    }

    public ElementLayer(@NonNull Activity activity) {
        super(activity);
        this.mElements = new ArrayList<>();
    }

    @PublicMethod
    public void addElement(@NonNull S s) {
        if (!this.mElements.contains(s)) {
            this.mElements.add(s);
        }
    }

    public void attachElementView(@NonNull S s) {
        BdViewOpUtils.removeView(s.getContentView());
        if (checkLayoutParams(s.getLayoutParams())) {
            this.mContainer.addView(s.getContentView(), s.getLayoutParams());
        } else {
            this.mContainer.addView(s.getContentView());
        }
    }

    public boolean checkLayoutParams(@Nullable ViewGroup.LayoutParams layoutParams) {
        if (getContentView() instanceof FrameLayout) {
            return layoutParams instanceof FrameLayout.LayoutParams;
        }
        if (getContentView() instanceof LinearLayout) {
            return layoutParams instanceof LinearLayout.LayoutParams;
        }
        if (getContentView() instanceof RelativeLayout) {
            return layoutParams instanceof RelativeLayout.LayoutParams;
        }
        return false;
    }

    public void detachElementView(@NonNull S s) {
        this.mContainer.removeView(s.getContentView());
    }

    @PublicMethod
    public void dispatchEvent(@NonNull VideoEvent videoEvent) {
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            it.next().onEventNotify(videoEvent);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void handleLayerMessage(Message message) {
        super.handleLayerMessage(message);
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            it.next().handleLayerMessage(message);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        super.onControlEventNotify(videoEvent);
        dispatchEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(@NonNull VideoEvent videoEvent) {
        super.onInteractiveEventNotify(videoEvent);
        dispatchEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onLayerEventNotify(videoEvent);
        dispatchEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onPlayerEventNotify(videoEvent);
        dispatchEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        super.onSystemEventNotify(videoEvent);
        dispatchEvent(videoEvent);
    }

    @PublicMethod
    public void removeElement(@NonNull S s) {
        if (this.mElements.remove(s)) {
            detachElementView(s);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.layer.ILayer
    @NonNull
    public T getContentView() {
        return this.mContainer;
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        super.onPlayerStatusChanged(playerStatus, playerStatus2);
        Iterator<S> it = this.mElements.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStatusChanged(playerStatus, playerStatus2);
        }
    }
}
