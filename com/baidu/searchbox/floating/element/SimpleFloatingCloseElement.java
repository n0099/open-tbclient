package com.baidu.searchbox.floating.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.floating.FloatView;
import com.baidu.searchbox.floating.element.SimpleFloatingCloseElement;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/floating/element/SimpleFloatingCloseElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "closeImageView", "Landroid/widget/ImageView;", "getCloseImageView", "()Landroid/widget/ImageView;", "closeImageView$delegate", "Lkotlin/Lazy;", "view", "Landroid/widget/LinearLayout;", "getView", "()Landroid/widget/LinearLayout;", "view$delegate", "getContentView", "initElement", "", "initImageView", "onClick", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SimpleFloatingCloseElement extends AbsElement {
    public final Lazy view$delegate = BdPlayerUtils.lazyNone(new Function0<LinearLayout>() { // from class: com.baidu.searchbox.floating.element.SimpleFloatingCloseElement$view$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LinearLayout invoke() {
            return new LinearLayout(SimpleFloatingCloseElement.this.getContext());
        }
    });
    public final Lazy closeImageView$delegate = BdPlayerUtils.lazyNone(new Function0<ImageView>() { // from class: com.baidu.searchbox.floating.element.SimpleFloatingCloseElement$closeImageView$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            ImageView initImageView;
            initImageView = SimpleFloatingCloseElement.this.initImageView();
            return initImageView;
        }
    });

    private final LinearLayout getView() {
        return (LinearLayout) this.view$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView initImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(UtilsKt.floatingImageViewSize(imageView), UtilsKt.floatingImageViewSize(imageView)));
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080278);
        return imageView;
    }

    public final ImageView getCloseImageView() {
        return (ImageView) this.closeImageView$delegate.getValue();
    }

    public void onClick() {
        FloatView.Companion.setClickCloseButton(true);
        getVideoPlayer().goBackOrForeground(false);
        getVideoPlayer().pause();
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        float f;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getAction(), FloatingLayerEvent.ACTION_FLOATING_GESTURE)) {
            boolean booleanExtra = event.getBooleanExtra(1);
            LinearLayout view2 = getView();
            if (booleanExtra) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            view2.setAlpha(f);
        }
    }

    /* renamed from: initElement$lambda-1$lambda-0  reason: not valid java name */
    public static final void m88initElement$lambda1$lambda0(SimpleFloatingCloseElement this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClick();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.element.IElement
    public LinearLayout getContentView() {
        return getView();
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        LinearLayout view2 = getView();
        view2.setId(ViewCompat.generateViewId());
        view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        view2.setPadding(BdPlayerUtils.dp2px(view2, 4.0f), BdPlayerUtils.dp2px(view2, 1.0f), BdPlayerUtils.dp2px(view2, 4.0f), BdPlayerUtils.dp2px(view2, 1.0f));
        view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f080277);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vi1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view3) == null) {
                    SimpleFloatingCloseElement.m88initElement$lambda1$lambda0(SimpleFloatingCloseElement.this, view3);
                }
            }
        });
        view2.setGravity(17);
        getView().addView(getCloseImageView());
    }
}
