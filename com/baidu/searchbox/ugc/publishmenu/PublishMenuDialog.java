package com.baidu.searchbox.ugc.publishmenu;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class PublishMenuDialog extends Dialog {
    private static final int COL_MAX = 3;
    private PublishMenuAdapter mAdapter;
    private View mCloseView;
    private Context mContext;
    private GridView mGridView;
    private OnItemClickListener mOnItemClickListener;

    /* loaded from: classes12.dex */
    public interface OnItemClickListener {
        void onItemClick(ItemInfo itemInfo);
    }

    public PublishMenuDialog(Context context) {
        super(context, R.style.ugc_publish_menu_dialog);
        this.mContext = context;
        UgcUBCUtils.enterUgc();
        initWindow();
        initView();
    }

    private void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setWindowAnimations(R.style.ugc_publish_menu_dialog_anim);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    private void initView() {
        View inflate = View.inflate(getContext(), R.layout.ugc_publish_dialog, null);
        inflate.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ugc_publish_menu_dialog_in));
        this.mGridView = (GridView) inflate.findViewById(ResourceUtils.getResIdByName("ugc_grid_view"));
        this.mCloseView = inflate.findViewById(ResourceUtils.getResIdByName("ugc_close_view"));
        updataUi(inflate);
        UiBaseUtils.setOnClickListener(this.mCloseView, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.publishmenu.PublishMenuDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UgcUBCUtils.clickLayerStatistics(2, UgcUBCUtils.mLayerBtnPage);
                UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
                PublishMenuDialog.this.dismiss();
            }
        });
        this.mAdapter = new PublishMenuAdapter(getContext());
        if (this.mGridView != null) {
            this.mGridView.setLayoutAnimation(getAnimationController());
            this.mGridView.setAdapter((ListAdapter) this.mAdapter);
            this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.searchbox.ugc.publishmenu.PublishMenuDialog.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (PublishMenuDialog.this.mOnItemClickListener != null) {
                        PublishMenuDialog.this.mOnItemClickListener.onItemClick(PublishMenuDialog.this.mAdapter.getItem(i));
                    }
                }
            });
        }
        setContentView(inflate);
    }

    private void updataUi(View view) {
        UgcUiUtils.setViewDrawable(view.findViewById(ResourceUtils.getResIdByName("ugc_items_layout")), R.drawable.ugc_publish_menu_dialog);
        UgcUiUtils.setViewColor(view.findViewById(ResourceUtils.getResIdByName("ugc_publish_dialog_line")), R.color.ugc_diolog_line_color);
        UgcUiUtils.setTextResource((TextView) this.mCloseView, R.color.ugc_publish_menu_text_selector);
    }

    protected LayoutAnimationController getAnimationController() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ugc_publish_menu_item_in);
        loadAnimation.setStartOffset(60L);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(loadAnimation, 0.1f);
        layoutAnimationController.setOrder(0);
        return layoutAnimationController;
    }

    public void setData(List<String> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                ItemInfo newInstance = ItemInfo.newInstance(str);
                if (newInstance != null) {
                    arrayList.add(newInstance);
                }
            }
            this.mGridView.setNumColumns(3);
            this.mAdapter.updateAll(arrayList);
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        UgcUBCUtils.exitPages(-1, UgcUBCUtils.mLayerPage);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
