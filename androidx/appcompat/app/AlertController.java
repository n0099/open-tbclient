package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class AlertController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListAdapter mAdapter;
    public int mAlertDialogLayout;
    public final View.OnClickListener mButtonHandler;
    public final int mButtonIconDimen;
    public Button mButtonNegative;
    public Drawable mButtonNegativeIcon;
    public Message mButtonNegativeMessage;
    public CharSequence mButtonNegativeText;
    public Button mButtonNeutral;
    public Drawable mButtonNeutralIcon;
    public Message mButtonNeutralMessage;
    public CharSequence mButtonNeutralText;
    public int mButtonPanelLayoutHint;
    public int mButtonPanelSideLayout;
    public Button mButtonPositive;
    public Drawable mButtonPositiveIcon;
    public Message mButtonPositiveMessage;
    public CharSequence mButtonPositiveText;
    public int mCheckedItem;
    public final Context mContext;
    public View mCustomTitleView;
    public final AppCompatDialog mDialog;
    public Handler mHandler;
    public Drawable mIcon;
    public int mIconId;
    public ImageView mIconView;
    public int mListItemLayout;
    public int mListLayout;
    public ListView mListView;
    public CharSequence mMessage;
    public TextView mMessageView;
    public int mMultiChoiceItemLayout;
    public NestedScrollView mScrollView;
    public boolean mShowTitle;
    public int mSingleChoiceItemLayout;
    public CharSequence mTitle;
    public TextView mTitleView;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified;
    public int mViewSpacingTop;
    public final Window mWindow;

    /* loaded from: classes.dex */
    public static class AlertParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId;
        public int mIconId;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified;
        public int mViewSpacingTop;

        /* loaded from: classes.dex */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
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
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void createListView(AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, alertController) == null) {
                RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
                if (this.mIsMultiChoice) {
                    if (this.mCursor == null) {
                        listAdapter = new ArrayAdapter<CharSequence>(this, this.mContext, alertController.mMultiChoiceItemLayout, 16908308, this.mItems, recycleListView) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AlertParams this$0;
                            public final /* synthetic */ RecycleListView val$listView;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r11, r12, r13, r14);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r11, Integer.valueOf(r12), Integer.valueOf(r13), r14, recycleListView};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Object[]) objArr2[3]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$listView = recycleListView;
                            }

                            @Override // android.widget.ArrayAdapter, android.widget.Adapter
                            public View getView(int i2, View view2, ViewGroup viewGroup) {
                                InterceptResult invokeILL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeILL = interceptable2.invokeILL(1048576, this, i2, view2, viewGroup)) == null) {
                                    View view3 = super.getView(i2, view2, viewGroup);
                                    boolean[] zArr = this.this$0.mCheckedItems;
                                    if (zArr != null && zArr[i2]) {
                                        this.val$listView.setItemChecked(i2, true);
                                    }
                                    return view3;
                                }
                                return (View) invokeILL.objValue;
                            }
                        };
                    } else {
                        listAdapter = new CursorAdapter(this, this.mContext, this.mCursor, false, recycleListView, alertController) { // from class: androidx.appcompat.app.AlertController.AlertParams.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final int mIsCheckedIndex;
                            public final int mLabelIndex;
                            public final /* synthetic */ AlertParams this$0;
                            public final /* synthetic */ AlertController val$dialog;
                            public final /* synthetic */ RecycleListView val$listView;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r10, r11, r12);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r10, r11, Boolean.valueOf(r12), recycleListView, alertController};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((Context) objArr2[0], (Cursor) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$listView = recycleListView;
                                this.val$dialog = alertController;
                                Cursor cursor = getCursor();
                                this.mLabelIndex = cursor.getColumnIndexOrThrow(this.this$0.mLabelColumn);
                                this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(this.this$0.mIsCheckedColumn);
                            }

                            @Override // android.widget.CursorAdapter
                            public void bindView(View view2, Context context, Cursor cursor) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, view2, context, cursor) == null) {
                                    ((CheckedTextView) view2.findViewById(16908308)).setText(cursor.getString(this.mLabelIndex));
                                    RecycleListView recycleListView2 = this.val$listView;
                                    int position = cursor.getPosition();
                                    boolean z = true;
                                    if (cursor.getInt(this.mIsCheckedIndex) != 1) {
                                        z = false;
                                    }
                                    recycleListView2.setItemChecked(position, z);
                                }
                            }

                            @Override // android.widget.CursorAdapter
                            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                                InterceptResult invokeLLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cursor, viewGroup)) == null) {
                                    return this.this$0.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, viewGroup, false);
                                }
                                return (View) invokeLLL.objValue;
                            }
                        };
                    }
                } else {
                    if (this.mIsSingleChoice) {
                        i = alertController.mSingleChoiceItemLayout;
                    } else {
                        i = alertController.mListItemLayout;
                    }
                    int i2 = i;
                    if (this.mCursor != null) {
                        listAdapter = new SimpleCursorAdapter(this.mContext, i2, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
                    } else {
                        listAdapter = this.mAdapter;
                        if (listAdapter == null) {
                            listAdapter = new CheckedItemAdapter(this.mContext, i2, 16908308, this.mItems);
                        }
                    }
                }
                OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
                if (onPrepareListViewListener != null) {
                    onPrepareListViewListener.onPrepareListView(recycleListView);
                }
                alertController.mAdapter = listAdapter;
                alertController.mCheckedItem = this.mCheckedItem;
                if (this.mOnClickListener != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, alertController) { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlertParams this$0;
                        public final /* synthetic */ AlertController val$dialog;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, alertController};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$dialog = alertController;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i3), Long.valueOf(j)}) == null) {
                                this.this$0.mOnClickListener.onClick(this.val$dialog.mDialog, i3);
                                if (!this.this$0.mIsSingleChoice) {
                                    this.val$dialog.mDialog.dismiss();
                                }
                            }
                        }
                    });
                } else if (this.mOnCheckboxClickListener != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, recycleListView, alertController) { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlertParams this$0;
                        public final /* synthetic */ AlertController val$dialog;
                        public final /* synthetic */ RecycleListView val$listView;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, recycleListView, alertController};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$listView = recycleListView;
                            this.val$dialog = alertController;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i3), Long.valueOf(j)}) == null) {
                                boolean[] zArr = this.this$0.mCheckedItems;
                                if (zArr != null) {
                                    zArr[i3] = this.val$listView.isItemChecked(i3);
                                }
                                this.this$0.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, i3, this.val$listView.isItemChecked(i3));
                            }
                        }
                    });
                }
                AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
                if (onItemSelectedListener != null) {
                    recycleListView.setOnItemSelectedListener(onItemSelectedListener);
                }
                if (this.mIsSingleChoice) {
                    recycleListView.setChoiceMode(1);
                } else if (this.mIsMultiChoice) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.mListView = recycleListView;
            }
        }

        public void apply(AlertController alertController) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, alertController) == null) {
                View view2 = this.mCustomTitleView;
                if (view2 != null) {
                    alertController.setCustomTitle(view2);
                } else {
                    CharSequence charSequence = this.mTitle;
                    if (charSequence != null) {
                        alertController.setTitle(charSequence);
                    }
                    Drawable drawable = this.mIcon;
                    if (drawable != null) {
                        alertController.setIcon(drawable);
                    }
                    int i = this.mIconId;
                    if (i != 0) {
                        alertController.setIcon(i);
                    }
                    int i2 = this.mIconAttrId;
                    if (i2 != 0) {
                        alertController.setIcon(alertController.getIconAttributeResId(i2));
                    }
                }
                CharSequence charSequence2 = this.mMessage;
                if (charSequence2 != null) {
                    alertController.setMessage(charSequence2);
                }
                if (this.mPositiveButtonText != null || this.mPositiveButtonIcon != null) {
                    alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
                }
                if (this.mNegativeButtonText != null || this.mNegativeButtonIcon != null) {
                    alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
                }
                if (this.mNeutralButtonText != null || this.mNeutralButtonIcon != null) {
                    alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
                }
                if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                    createListView(alertController);
                }
                View view3 = this.mView;
                if (view3 != null) {
                    if (this.mViewSpacingSpecified) {
                        alertController.setView(view3, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                        return;
                    } else {
                        alertController.setView(view3);
                        return;
                    }
                }
                int i3 = this.mViewLayoutResId;
                if (i3 != 0) {
                    alertController.setView(i3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class ButtonHandler extends Handler {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_DISMISS_DIALOG = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialogInterface};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != -3 && i != -2 && i != -1) {
                    if (i == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        return;
                    }
                    return;
                }
                ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), charSequenceArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Object[]) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mPaddingBottomNoButtons;
        public final int mPaddingTopNoTitle;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RecycleListView(Context context) {
            this(context, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z2 || !z) {
                    int paddingLeft = getPaddingLeft();
                    if (z) {
                        i = getPaddingTop();
                    } else {
                        i = this.mPaddingTopNoTitle;
                    }
                    int paddingRight = getPaddingRight();
                    if (z2) {
                        i2 = getPaddingBottom();
                    } else {
                        i2 = this.mPaddingBottomNoButtons;
                    }
                    setPadding(paddingLeft, i, paddingRight, i2);
                }
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, appCompatDialog, window};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new View.OnClickListener(this) { // from class: androidx.appcompat.app.AlertController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlertController this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Message message;
                Message message2;
                Message message3;
                Message message4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    AlertController alertController = this.this$0;
                    if (view2 == alertController.mButtonPositive && (message4 = alertController.mButtonPositiveMessage) != null) {
                        message = Message.obtain(message4);
                    } else {
                        AlertController alertController2 = this.this$0;
                        if (view2 == alertController2.mButtonNegative && (message3 = alertController2.mButtonNegativeMessage) != null) {
                            message = Message.obtain(message3);
                        } else {
                            AlertController alertController3 = this.this$0;
                            if (view2 == alertController3.mButtonNeutral && (message2 = alertController3.mButtonNeutralMessage) != null) {
                                message = Message.obtain(message2);
                            } else {
                                message = null;
                            }
                        }
                    }
                    if (message != null) {
                        message.sendToTarget();
                    }
                    AlertController alertController4 = this.this$0;
                    alertController4.mHandler.obtainMessage(1, alertController4.mDialog).sendToTarget();
                }
            }
        };
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, com.baidu.tieba.R.attr.obfuscated_res_0x7f040087, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(0, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(2, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(4, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(5, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(7, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(3, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(6, true);
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    public static boolean canTextInput(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2.onCheckIsTextEditor()) {
                return true;
            }
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (canTextInput(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void centerButton(Button button) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, button) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.weight = 0.5f;
            button.setLayoutParams(layoutParams);
        }
    }

    public static boolean shouldCenterSingleButton(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.baidu.tieba.R.attr.obfuscated_res_0x7f040086, typedValue, true);
            if (typedValue.data != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Button getButton(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i != -3) {
                if (i != -2) {
                    if (i != -1) {
                        return null;
                    }
                    return this.mButtonPositive;
                }
                return this.mButtonNegative;
            }
            return this.mButtonNeutral;
        }
        return (Button) invokeI.objValue;
    }

    public int getIconAttributeResId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(i, typedValue, true);
            return typedValue.resourceId;
        }
        return invokeI.intValue;
    }

    public void setButtonPanelLayoutHint(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mButtonPanelLayoutHint = i;
        }
    }

    public void setCustomTitle(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            this.mCustomTitleView = view2;
        }
    }

    public void setIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mIcon = null;
            this.mIconId = i;
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                if (i != 0) {
                    imageView.setVisibility(0);
                    this.mIconView.setImageResource(this.mIconId);
                    return;
                }
                imageView.setVisibility(8);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, charSequence) == null) {
            this.mMessage = charSequence;
            TextView textView = this.mMessageView;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
            this.mTitle = charSequence;
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public void setView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mView = null;
            this.mViewLayoutResId = i;
            this.mViewSpacingSpecified = false;
        }
    }

    public static void manageScrollIndicators(View view2, View view3, View view4) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, view2, view3, view4) == null) {
            int i2 = 0;
            if (view3 != null) {
                if (view2.canScrollVertically(-1)) {
                    i = 0;
                } else {
                    i = 4;
                }
                view3.setVisibility(i);
            }
            if (view4 != null) {
                if (!view2.canScrollVertically(1)) {
                    i2 = 4;
                }
                view4.setVisibility(i2);
            }
        }
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view2, @Nullable View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, view3)) == null) {
            if (view2 == null) {
                if (view3 instanceof ViewStub) {
                    view3 = ((ViewStub) view3).inflate();
                }
                return (ViewGroup) view3;
            }
            if (view3 != null) {
                ViewParent parent = view3.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view3);
                }
            }
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        return (ViewGroup) invokeLL.objValue;
    }

    private int selectContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.mButtonPanelSideLayout;
            if (i == 0) {
                return this.mAlertDialogLayout;
            }
            if (this.mButtonPanelLayoutHint == 1) {
                return i;
            }
            return this.mAlertDialogLayout;
        }
        return invokeV.intValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mListView;
        }
        return (ListView) invokeV.objValue;
    }

    public void installContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mDialog.setContentView(selectContentView());
            setupView();
        }
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65542, this, viewGroup, view2, i, i2) == null) {
            View findViewById = this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091e1d);
            View findViewById2 = this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091e1c);
            if (Build.VERSION.SDK_INT >= 23) {
                ViewCompat.setScrollIndicators(view2, i, i2);
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 != null) {
                    viewGroup.removeView(findViewById2);
                    return;
                }
                return;
            }
            if (findViewById != null && (i & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById != null || findViewById2 != null) {
                if (this.mMessage != null) {
                    this.mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this, findViewById, findViewById2) { // from class: androidx.appcompat.app.AlertController.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlertController this$0;
                        public final /* synthetic */ View val$bottom;
                        public final /* synthetic */ View val$top;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, findViewById, findViewById2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$top = findViewById;
                            this.val$bottom = findViewById2;
                        }

                        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                        public void onScrollChange(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{nestedScrollView, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                                AlertController.manageScrollIndicators(nestedScrollView, this.val$top, this.val$bottom);
                            }
                        }
                    });
                    this.mScrollView.post(new Runnable(this, findViewById, findViewById2) { // from class: androidx.appcompat.app.AlertController.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlertController this$0;
                        public final /* synthetic */ View val$bottom;
                        public final /* synthetic */ View val$top;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, findViewById, findViewById2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$top = findViewById;
                            this.val$bottom = findViewById2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                AlertController.manageScrollIndicators(this.this$0.mScrollView, this.val$top, this.val$bottom);
                            }
                        }
                    });
                    return;
                }
                ListView listView = this.mListView;
                if (listView != null) {
                    listView.setOnScrollListener(new AbsListView.OnScrollListener(this, findViewById, findViewById2) { // from class: androidx.appcompat.app.AlertController.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlertController this$0;
                        public final /* synthetic */ View val$bottom;
                        public final /* synthetic */ View val$top;

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView absListView, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i3) == null) {
                            }
                        }

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, findViewById, findViewById2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$top = findViewById;
                            this.val$bottom = findViewById2;
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i3, i4, i5) == null) {
                                AlertController.manageScrollIndicators(absListView, this.val$top, this.val$bottom);
                            }
                        }
                    });
                    this.mListView.post(new Runnable(this, findViewById, findViewById2) { // from class: androidx.appcompat.app.AlertController.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlertController this$0;
                        public final /* synthetic */ View val$bottom;
                        public final /* synthetic */ View val$top;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, findViewById, findViewById2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$top = findViewById;
                            this.val$bottom = findViewById2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                AlertController.manageScrollIndicators(this.this$0.mListView, this.val$top, this.val$bottom);
                            }
                        }
                    });
                    return;
                }
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 != null) {
                    viewGroup.removeView(findViewById2);
                }
            }
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, viewGroup) == null) {
            Button button = (Button) viewGroup.findViewById(16908313);
            this.mButtonPositive = button;
            button.setOnClickListener(this.mButtonHandler);
            boolean z2 = true;
            if (TextUtils.isEmpty(this.mButtonPositiveText) && this.mButtonPositiveIcon == null) {
                this.mButtonPositive.setVisibility(8);
                z = false;
            } else {
                this.mButtonPositive.setText(this.mButtonPositiveText);
                Drawable drawable = this.mButtonPositiveIcon;
                if (drawable != null) {
                    int i = this.mButtonIconDimen;
                    drawable.setBounds(0, 0, i, i);
                    this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
                }
                this.mButtonPositive.setVisibility(0);
                z = true;
            }
            Button button2 = (Button) viewGroup.findViewById(16908314);
            this.mButtonNegative = button2;
            button2.setOnClickListener(this.mButtonHandler);
            if (TextUtils.isEmpty(this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
                this.mButtonNegative.setVisibility(8);
            } else {
                this.mButtonNegative.setText(this.mButtonNegativeText);
                Drawable drawable2 = this.mButtonNegativeIcon;
                if (drawable2 != null) {
                    int i2 = this.mButtonIconDimen;
                    drawable2.setBounds(0, 0, i2, i2);
                    this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
                }
                this.mButtonNegative.setVisibility(0);
                z |= true;
            }
            Button button3 = (Button) viewGroup.findViewById(16908315);
            this.mButtonNeutral = button3;
            button3.setOnClickListener(this.mButtonHandler);
            if (TextUtils.isEmpty(this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
                this.mButtonNeutral.setVisibility(8);
            } else {
                this.mButtonNeutral.setText(this.mButtonNeutralText);
                Drawable drawable3 = this.mButtonNeutralIcon;
                if (drawable3 != null) {
                    int i3 = this.mButtonIconDimen;
                    drawable3.setBounds(0, 0, i3, i3);
                    this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
                }
                this.mButtonNeutral.setVisibility(0);
                z |= true;
            }
            if (shouldCenterSingleButton(this.mContext)) {
                if (z) {
                    centerButton(this.mButtonPositive);
                } else if (z) {
                    centerButton(this.mButtonNegative);
                } else if (z) {
                    centerButton(this.mButtonNeutral);
                }
            }
            if (!z) {
                z2 = false;
            }
            if (!z2) {
                viewGroup.setVisibility(8);
            }
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, viewGroup) == null) {
            NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091e1e);
            this.mScrollView = nestedScrollView;
            nestedScrollView.setFocusable(false);
            this.mScrollView.setNestedScrollingEnabled(false);
            TextView textView = (TextView) viewGroup.findViewById(16908299);
            this.mMessageView = textView;
            if (textView == null) {
                return;
            }
            CharSequence charSequence = this.mMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if (this.mListView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.mScrollView.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.mScrollView);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, viewGroup) == null) {
            View view2 = this.mView;
            boolean z = false;
            if (view2 == null) {
                if (this.mViewLayoutResId != 0) {
                    view2 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false);
                } else {
                    view2 = null;
                }
            }
            if (view2 != null) {
                z = true;
            }
            if (!z || !canTextInput(view2)) {
                this.mWindow.setFlags(131072, 131072);
            }
            if (z) {
                FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090766);
                frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
                if (this.mViewSpacingSpecified) {
                    frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                }
                if (this.mListView != null) {
                    ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                    return;
                }
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void setupTitle(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, viewGroup) == null) {
            if (this.mCustomTitleView != null) {
                viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
                this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09228d).setVisibility(8);
                return;
            }
            this.mIconView = (ImageView) this.mWindow.findViewById(16908294);
            if ((!TextUtils.isEmpty(this.mTitle)) && this.mShowTitle) {
                TextView textView = (TextView) this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090275);
                this.mTitleView = textView;
                textView.setText(this.mTitle);
                int i = this.mIconId;
                if (i != 0) {
                    this.mIconView.setImageResource(i);
                    return;
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    this.mIconView.setImageDrawable(drawable);
                    return;
                }
                this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                this.mIconView.setVisibility(8);
                return;
            }
            this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09228d).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        boolean z;
        boolean z2;
        boolean z3;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View findViewById3 = this.mWindow.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0917cd);
            View findViewById4 = findViewById3.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0922d4);
            View findViewById5 = findViewById3.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0906fe);
            View findViewById6 = findViewById3.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090498);
            ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090767);
            setupCustomContent(viewGroup);
            View findViewById7 = viewGroup.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0922d4);
            View findViewById8 = viewGroup.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0906fe);
            View findViewById9 = viewGroup.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090498);
            ViewGroup resolvePanel = resolvePanel(findViewById7, findViewById4);
            ViewGroup resolvePanel2 = resolvePanel(findViewById8, findViewById5);
            ViewGroup resolvePanel3 = resolvePanel(findViewById9, findViewById6);
            setupContent(resolvePanel2);
            setupButtons(resolvePanel3);
            setupTitle(resolvePanel);
            int i = 0;
            if (viewGroup != null && viewGroup.getVisibility() != 8) {
                z = true;
            } else {
                z = false;
            }
            if (resolvePanel != null && resolvePanel.getVisibility() != 8) {
                z2 = 1;
            } else {
                z2 = 0;
            }
            if (resolvePanel3 != null && resolvePanel3.getVisibility() != 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3 && resolvePanel2 != null && (findViewById2 = resolvePanel2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092164)) != null) {
                findViewById2.setVisibility(0);
            }
            if (z2) {
                NestedScrollView nestedScrollView = this.mScrollView;
                if (nestedScrollView != null) {
                    nestedScrollView.setClipToPadding(true);
                }
                View view2 = null;
                if (this.mMessage != null || this.mListView != null) {
                    view2 = resolvePanel.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092265);
                }
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else if (resolvePanel2 != null && (findViewById = resolvePanel2.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092165)) != null) {
                findViewById.setVisibility(0);
            }
            ListView listView = this.mListView;
            if (listView instanceof RecycleListView) {
                ((RecycleListView) listView).setHasDecor(z2, z3);
            }
            if (!z) {
                View view3 = this.mListView;
                if (view3 == null) {
                    view3 = this.mScrollView;
                }
                if (view3 != null) {
                    if (z3) {
                        i = 2;
                    }
                    setScrollIndicators(resolvePanel2, view3, z2 | i, 3);
                }
            }
            ListView listView2 = this.mListView;
            if (listView2 != null && (listAdapter = this.mAdapter) != null) {
                listView2.setAdapter(listAdapter);
                int i2 = this.mCheckedItem;
                if (i2 > -1) {
                    listView2.setItemChecked(i2, true);
                    listView2.setSelection(i2);
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, keyEvent)) == null) {
            NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), charSequence, onClickListener, message, drawable}) == null) {
            if (message == null && onClickListener != null) {
                message = this.mHandler.obtainMessage(i, onClickListener);
            }
            if (i != -3) {
                if (i != -2) {
                    if (i == -1) {
                        this.mButtonPositiveText = charSequence;
                        this.mButtonPositiveMessage = message;
                        this.mButtonPositiveIcon = drawable;
                        return;
                    }
                    throw new IllegalArgumentException("Button does not exist");
                }
                this.mButtonNegativeText = charSequence;
                this.mButtonNegativeMessage = message;
                this.mButtonNegativeIcon = drawable;
                return;
            }
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
            this.mButtonNeutralIcon = drawable;
        }
    }

    public void setView(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mView = view2;
            this.mViewLayoutResId = 0;
            this.mViewSpacingSpecified = true;
            this.mViewSpacingLeft = i;
            this.mViewSpacingTop = i2;
            this.mViewSpacingRight = i3;
            this.mViewSpacingBottom = i4;
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.mIcon = drawable;
            this.mIconId = 0;
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setVisibility(0);
                    this.mIconView.setImageDrawable(drawable);
                    return;
                }
                imageView.setVisibility(8);
            }
        }
    }

    public void setView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            this.mView = view2;
            this.mViewLayoutResId = 0;
            this.mViewSpacingSpecified = false;
        }
    }
}
