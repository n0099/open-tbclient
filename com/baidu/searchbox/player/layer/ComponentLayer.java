package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.component.AbsComponent;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class ComponentLayer<T extends ViewGroup> extends AbsLayer implements View.OnClickListener {
    public ArrayList<AbsComponent> mComponents;
    public T mContainer;

    public ComponentLayer() {
        this.mComponents = new ArrayList<>();
    }

    @PublicMethod
    public void addComponent(@NonNull AbsComponent absComponent) {
        this.mComponents.add(absComponent);
    }

    public void attachComponentView(@NonNull AbsComponent absComponent) {
        if (absComponent.getContentView() != null) {
            BdViewOpUtils.removeView(absComponent.getContentView());
            this.mContainer.addView(absComponent.getContentView());
        }
    }

    public void detachComponentView(@NonNull AbsComponent absComponent) {
        if (absComponent.getContentView() != null) {
            this.mContainer.removeView(absComponent.getContentView());
        }
    }

    @PublicMethod
    public void dispatcherEvent(@NonNull VideoEvent videoEvent) {
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onEventNotify(videoEvent);
        }
    }

    @PublicMethod
    public ArrayList<AbsComponent> getComponents() {
        return this.mComponents;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{4, 5, 2, 3, 1};
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void handleLayerMessage(Message message) {
        super.handleLayerMessage(message);
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().handleLayerMessage(message);
        }
    }

    public abstract void initContainer();

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initContainer();
        this.mContainer.setLayoutParams(layoutParams);
        setupComponent();
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            AbsComponent next = it.next();
            next.setParent(this);
            next.initComponent();
            if (next.attachToRootAtOnce()) {
                attachComponentView(next);
            }
        }
        layoutComponent(this.mContainer);
    }

    public void layoutComponent(T t) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
        super.onContainerDetach();
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onContainerDetach();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        super.onControlEventNotify(videoEvent);
        dispatcherEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        super.onLayerDetach();
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onLayerDetach();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onLayerEventNotify(videoEvent);
        dispatcherEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        super.onLayerRelease();
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onLayerRelease();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onPlayerEventNotify(videoEvent);
        dispatcherEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        super.onPlayerStatusChanged(playerStatus, playerStatus2);
        Iterator<AbsComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStatusChanged(playerStatus, playerStatus2);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        super.onSystemEventNotify(videoEvent);
        dispatcherEvent(videoEvent);
    }

    public abstract void setupComponent();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.layer.ILayer
    public T getContentView() {
        return this.mContainer;
    }

    public ComponentLayer(@NonNull Activity activity) {
        super(activity);
        this.mComponents = new ArrayList<>();
    }
}
