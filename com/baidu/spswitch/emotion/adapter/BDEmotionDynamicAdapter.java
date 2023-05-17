package com.baidu.spswitch.emotion.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.emotion.bean.EmotionTitleModel;
import com.baidu.spswitch.utils.EmoAlphaChangeHelper;
import com.baidu.spswitch.utils.EmotionPreviewHandler;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BDEmotionDynamicAdapter extends RecyclerView.Adapter<BaseEmotionHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ITEM_TYPE_IMAGE = 2;
    public static final int ITEM_TYPE_TEXT = 1;
    public static final int ITEM_TYPE_TITLE = 0;
    public static final int ITEM_TYPE_UNKNOWN = -1;
    public static final String TAG = "BDEmotionDynamicAdapter";
    public transient /* synthetic */ FieldHolder $fh;
    public EmoAlphaChangeHelper mAlphaChangeHelper;
    public Context mContext;
    public List<EmotionDynamicData> mData;
    public OnEmotionClickListener mEmotionClickListener;
    public EmotionPreviewHandler mEmotionPreviewHandler;

    /* loaded from: classes4.dex */
    public interface OnEmotionClickListener {
        void onClick(@Nullable View view2, int i, @Nullable Object obj);
    }

    /* loaded from: classes4.dex */
    public static abstract class BaseEmotionHolder<DATA> extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mItemType;

        public abstract void onBindViewHolder(int i, @Nullable DATA data);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseEmotionHolder(View view2, int i) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mItemType = i;
        }

        public static BaseEmotionHolder createViewHolder(ViewGroup viewGroup, int i, Context context) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, viewGroup, i, context)) == null) {
                LayoutInflater from = LayoutInflater.from(context);
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return new EmotionImageHolder(from.inflate(R.layout.emotion_grid_item_imageview, viewGroup, false), i);
                    }
                    return new EmotionTextHolder(from.inflate(R.layout.emotion_grid_item_emo_text, viewGroup, false), i);
                }
                return new EmotionTitleHolder(from.inflate(R.layout.emotion_dynamic_panel_title, viewGroup, false), i);
            }
            return (BaseEmotionHolder) invokeLIL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class EmotionDynamicData<DATA> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DATA data;
        public int itemType;

        public EmotionDynamicData(int i, DATA data) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), data};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.itemType = i;
            this.data = data;
        }
    }

    /* loaded from: classes4.dex */
    public static class EmotionImageHolder extends BaseEmotionHolder<EmotionItemModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SimpleDraweeView image;
        public final TextView name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionImageHolder(View view2, int i) {
            super(view2, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.image = (SimpleDraweeView) view2.findViewById(R.id.item_img);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09118c);
            this.name = textView;
            textView.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.obfuscated_res_0x7f060240));
            this.image.getHierarchy().setPlaceholderImage(R.drawable.emotion_preview_placeholder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.BaseEmotionHolder
        public void onBindViewHolder(int i, @Nullable EmotionItemModel emotionItemModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, emotionItemModel) == null) && emotionItemModel != null) {
                if (!TextUtils.isEmpty(emotionItemModel.getUrl())) {
                    this.image.setImageURI(emotionItemModel.getUrl());
                }
                this.name.setText(emotionItemModel.getText());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class EmotionTextHolder extends BaseEmotionHolder<EmotionItemModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SimpleDraweeView simpleDraweeView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionTextHolder(View view2, int i) {
            super(view2, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            view2.setBackground(ContextCompat.getDrawable(view2.getContext(), R.drawable.emotion_text_background));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.item_text_img);
            this.simpleDraweeView = simpleDraweeView;
            simpleDraweeView.getHierarchy().setPlaceholderImage(R.drawable.emotion_text_place_holder, ScalingUtils.ScaleType.FIT_CENTER);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.BaseEmotionHolder
        public void onBindViewHolder(int i, @Nullable EmotionItemModel emotionItemModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, emotionItemModel) == null) && emotionItemModel != null) {
                this.simpleDraweeView.setImageURI(emotionItemModel.getUrl());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class EmotionTitleHolder extends BaseEmotionHolder<EmotionTitleModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView title;
        public final SimpleDraweeView vipIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionTitleHolder(View view2, int i) {
            super(view2, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.title = (TextView) view2.findViewById(R.id.emotion_title);
            this.vipIcon = (SimpleDraweeView) view2.findViewById(R.id.emotion_vip_icon);
            this.title.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.obfuscated_res_0x7f060241));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.BaseEmotionHolder
        public void onBindViewHolder(int i, @Nullable EmotionTitleModel emotionTitleModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, emotionTitleModel) == null) && emotionTitleModel != null) {
                this.title.setText(emotionTitleModel.getTitle());
                this.vipIcon.setImageURI(emotionTitleModel.getVipIcon());
            }
        }
    }

    public BDEmotionDynamicAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mData = new ArrayList();
        this.mContext = context;
    }

    @Nullable
    public Object getDataByPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<EmotionDynamicData> list = this.mData;
            if (list != null && !list.isEmpty() && i < this.mData.size() && i >= 0) {
                return this.mData.get(i).data;
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<EmotionDynamicData> list = this.mData;
            if (list != null && !list.isEmpty()) {
                return this.mData.get(i).itemType;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void setAlphaChangeHelper(@NonNull EmoAlphaChangeHelper emoAlphaChangeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, emoAlphaChangeHelper) == null) {
            this.mAlphaChangeHelper = emoAlphaChangeHelper;
        }
    }

    public void setData(@Nullable List<EmotionDynamicData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && !list.isEmpty()) {
            this.mData.clear();
            this.mData.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setEmotionPreviewHandler(@NonNull EmotionPreviewHandler emotionPreviewHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, emotionPreviewHandler) == null) {
            this.mEmotionPreviewHandler = emotionPreviewHandler;
        }
    }

    public void setOnEmotionClickListener(@Nullable OnEmotionClickListener onEmotionClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onEmotionClickListener) == null) {
            this.mEmotionClickListener = onEmotionClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<EmotionDynamicData> list = this.mData;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@Nullable BaseEmotionHolder baseEmotionHolder, int i) {
        List<EmotionDynamicData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, baseEmotionHolder, i) == null) && (list = this.mData) != null && !list.isEmpty() && baseEmotionHolder != null) {
            baseEmotionHolder.itemView.setOnLongClickListener(new View.OnLongClickListener(this, i) { // from class: com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionDynamicAdapter this$0;
                public final /* synthetic */ int val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = i;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        if (this.this$0.mEmotionPreviewHandler != null) {
                            this.this$0.mEmotionPreviewHandler.onLongClick(view2, this.val$position, ((EmotionDynamicData) this.this$0.mData.get(this.val$position)).data);
                            return false;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            baseEmotionHolder.itemView.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionDynamicAdapter this$0;
                public final /* synthetic */ int val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = i;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.this$0.mEmotionClickListener != null) {
                        this.this$0.mEmotionClickListener.onClick(view2, this.val$position, ((EmotionDynamicData) this.this$0.mData.get(this.val$position)).data);
                    }
                }
            });
            if (this.mEmotionClickListener != null) {
                baseEmotionHolder.itemView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BDEmotionDynamicAdapter this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            if (this.this$0.mEmotionPreviewHandler != null) {
                                return this.this$0.mEmotionPreviewHandler.onTouch(view2, motionEvent);
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
            if (baseEmotionHolder.mItemType == baseEmotionHolder.getItemViewType()) {
                baseEmotionHolder.onBindViewHolder(i, this.mData.get(i).data);
            }
            this.mAlphaChangeHelper.processAlpha((ViewGroup) baseEmotionHolder.itemView, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public BaseEmotionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            return BaseEmotionHolder.createViewHolder(viewGroup, i, this.mContext);
        }
        return (BaseEmotionHolder) invokeLI.objValue;
    }
}
