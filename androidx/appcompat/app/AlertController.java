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
import com.baidu.mobads.container.util.AdIconUtil;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2;
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
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
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
                            public View getView(int i3, View view, ViewGroup viewGroup) {
                                InterceptResult invokeILL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeILL = interceptable2.invokeILL(1048576, this, i3, view, viewGroup)) == null) {
                                    View view2 = super.getView(i3, view, viewGroup);
                                    boolean[] zArr = this.this$0.mCheckedItems;
                                    if (zArr != null && zArr[i3]) {
                                        this.val$listView.setItemChecked(i3, true);
                                    }
                                    return view2;
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
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
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
                            public void bindView(View view, Context context, Cursor cursor) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, view, context, cursor) == null) {
                                    ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.mLabelIndex));
                                    this.val$listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.mIsCheckedIndex) == 1);
                                }
                            }

                            @Override // android.widget.CursorAdapter
                            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                                InterceptResult invokeLLL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cursor, viewGroup)) == null) ? this.this$0.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, viewGroup, false) : (View) invokeLLL.objValue;
                            }
                        };
                    }
                } else {
                    if (this.mIsSingleChoice) {
                        i2 = alertController.mSingleChoiceItemLayout;
                    } else {
                        i2 = alertController.mListItemLayout;
                    }
                    int i3 = i2;
                    if (this.mCursor != null) {
                        listAdapter = new SimpleCursorAdapter(this.mContext, i3, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
                    } else {
                        listAdapter = this.mAdapter;
                        if (listAdapter == null) {
                            listAdapter = new CheckedItemAdapter(this.mContext, i3, 16908308, this.mItems);
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
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$dialog = alertController;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
                                this.this$0.mOnClickListener.onClick(this.val$dialog.mDialog, i4);
                                if (this.this$0.mIsSingleChoice) {
                                    return;
                                }
                                this.val$dialog.mDialog.dismiss();
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
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
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
                        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
                                boolean[] zArr = this.this$0.mCheckedItems;
                                if (zArr != null) {
                                    zArr[i4] = this.val$listView.isItemChecked(i4);
                                }
                                this.this$0.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, i4, this.val$listView.isItemChecked(i4));
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
                View view = this.mCustomTitleView;
                if (view != null) {
                    alertController.setCustomTitle(view);
                } else {
                    CharSequence charSequence = this.mTitle;
                    if (charSequence != null) {
                        alertController.setTitle(charSequence);
                    }
                    Drawable drawable = this.mIcon;
                    if (drawable != null) {
                        alertController.setIcon(drawable);
                    }
                    int i2 = this.mIconId;
                    if (i2 != 0) {
                        alertController.setIcon(i2);
                    }
                    int i3 = this.mIconAttrId;
                    if (i3 != 0) {
                        alertController.setIcon(alertController.getIconAttributeResId(i3));
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
                View view2 = this.mView;
                if (view2 != null) {
                    if (this.mViewSpacingSpecified) {
                        alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                        return;
                    } else {
                        alertController.setView(view2);
                        return;
                    }
                }
                int i4 = this.mViewLayoutResId;
                if (i4 != 0) {
                    alertController.setView(i4);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = message.what;
                if (i2 == -3 || i2 == -2 || i2 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
                } else if (i2 != 1) {
                } else {
                    ((DialogInterface) message.obj).dismiss();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckedItemAdapter(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), charSequenceArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Object[]) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 : invokeI.longValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void setHasDecor(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (z2 && z) {
                    return;
                }
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, appCompatDialog, window};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Message obtain;
                Message message;
                Message message2;
                Message message3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    AlertController alertController = this.this$0;
                    if (view == alertController.mButtonPositive && (message3 = alertController.mButtonPositiveMessage) != null) {
                        obtain = Message.obtain(message3);
                    } else {
                        AlertController alertController2 = this.this$0;
                        if (view == alertController2.mButtonNegative && (message2 = alertController2.mButtonNegativeMessage) != null) {
                            obtain = Message.obtain(message2);
                        } else {
                            AlertController alertController3 = this.this$0;
                            obtain = (view != alertController3.mButtonNeutral || (message = alertController3.mButtonNeutralMessage) == null) ? null : Message.obtain(message);
                        }
                    }
                    if (obtain != null) {
                        obtain.sendToTarget();
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    public static boolean canTextInput(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (view.onCheckIsTextEditor()) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                while (childCount > 0) {
                    childCount--;
                    if (canTextInput(viewGroup.getChildAt(childCount))) {
                        return true;
                    }
                }
                return false;
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

    public static void manageScrollIndicators(View view, View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, view, view2, view3) == null) {
            if (view2 != null) {
                view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
            }
            if (view3 != null) {
                view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
            }
        }
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, view2)) == null) {
            if (view == null) {
                if (view2 instanceof ViewStub) {
                    view2 = ((ViewStub) view2).inflate();
                }
                return (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view2);
                }
            }
            if (view instanceof ViewStub) {
                view = ((ViewStub) view).inflate();
            }
            return (ViewGroup) view;
        }
        return (ViewGroup) invokeLL.objValue;
    }

    private int selectContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            int i2 = this.mButtonPanelSideLayout;
            if (i2 == 0) {
                return this.mAlertDialogLayout;
            }
            return this.mButtonPanelLayoutHint == 1 ? i2 : this.mAlertDialogLayout;
        }
        return invokeV.intValue;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(AdIconUtil.BAIDU_LOGO_ID, this, viewGroup, view, i2, i3) == null) {
            View findViewById = this.mWindow.findViewById(R.id.scrollIndicatorUp);
            View findViewById2 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
            if (Build.VERSION.SDK_INT >= 23) {
                ViewCompat.setScrollIndicators(view, i2, i3);
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 != null) {
                    viewGroup.removeView(findViewById2);
                    return;
                }
                return;
            }
            if (findViewById != null && (i2 & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i2 & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById == null && findViewById2 == null) {
                return;
            }
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
                    public void onScrollChange(NestedScrollView nestedScrollView, int i4, int i5, int i6, int i7) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{nestedScrollView, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, findViewById, findViewById2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
                    public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i4, i5, i6) == null) {
                            AlertController.manageScrollIndicators(absListView, this.val$top, this.val$bottom);
                        }
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i4) == null) {
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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

    private void setupButtons(ViewGroup viewGroup) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, viewGroup) == null) {
            Button button = (Button) viewGroup.findViewById(16908313);
            this.mButtonPositive = button;
            button.setOnClickListener(this.mButtonHandler);
            if (TextUtils.isEmpty(this.mButtonPositiveText) && this.mButtonPositiveIcon == null) {
                this.mButtonPositive.setVisibility(8);
                z = false;
            } else {
                this.mButtonPositive.setText(this.mButtonPositiveText);
                Drawable drawable = this.mButtonPositiveIcon;
                if (drawable != null) {
                    int i2 = this.mButtonIconDimen;
                    drawable.setBounds(0, 0, i2, i2);
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
                    int i3 = this.mButtonIconDimen;
                    drawable2.setBounds(0, 0, i3, i3);
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
                    int i4 = this.mButtonIconDimen;
                    drawable3.setBounds(0, 0, i4, i4);
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
            if (z) {
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, viewGroup) == null) {
            NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(R.id.scrollView);
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
            View view = this.mView;
            if (view == null) {
                view = this.mViewLayoutResId != 0 ? LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
            }
            boolean z = view != null;
            if (!z || !canTextInput(view)) {
                this.mWindow.setFlags(131072, 131072);
            }
            if (z) {
                FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(R.id.custom);
                frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
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
                this.mWindow.findViewById(R.id.title_template).setVisibility(8);
                return;
            }
            this.mIconView = (ImageView) this.mWindow.findViewById(16908294);
            if ((!TextUtils.isEmpty(this.mTitle)) && this.mShowTitle) {
                TextView textView = (TextView) this.mWindow.findViewById(R.id.alertTitle);
                this.mTitleView = textView;
                textView.setText(this.mTitle);
                int i2 = this.mIconId;
                if (i2 != 0) {
                    this.mIconView.setImageResource(i2);
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
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r7v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View findViewById3 = this.mWindow.findViewById(R.id.parentPanel);
            View findViewById4 = findViewById3.findViewById(R.id.topPanel);
            View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
            View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
            ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
            setupCustomContent(viewGroup);
            View findViewById7 = viewGroup.findViewById(R.id.topPanel);
            View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
            View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
            ViewGroup resolvePanel = resolvePanel(findViewById7, findViewById4);
            ViewGroup resolvePanel2 = resolvePanel(findViewById8, findViewById5);
            ViewGroup resolvePanel3 = resolvePanel(findViewById9, findViewById6);
            setupContent(resolvePanel2);
            setupButtons(resolvePanel3);
            setupTitle(resolvePanel);
            boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
            boolean z2 = (resolvePanel == null || resolvePanel.getVisibility() == 8) ? 0 : 1;
            boolean z3 = (resolvePanel3 == null || resolvePanel3.getVisibility() == 8) ? false : true;
            if (!z3 && resolvePanel2 != null && (findViewById2 = resolvePanel2.findViewById(R.id.textSpacerNoButtons)) != null) {
                findViewById2.setVisibility(0);
            }
            if (z2) {
                NestedScrollView nestedScrollView = this.mScrollView;
                if (nestedScrollView != null) {
                    nestedScrollView.setClipToPadding(true);
                }
                View view = null;
                if (this.mMessage != null || this.mListView != null) {
                    view = resolvePanel.findViewById(R.id.titleDividerNoCustom);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
            } else if (resolvePanel2 != null && (findViewById = resolvePanel2.findViewById(R.id.textSpacerNoTitle)) != null) {
                findViewById.setVisibility(0);
            }
            ListView listView = this.mListView;
            if (listView instanceof RecycleListView) {
                ((RecycleListView) listView).setHasDecor(z2, z3);
            }
            if (!z) {
                View view2 = this.mListView;
                if (view2 == null) {
                    view2 = this.mScrollView;
                }
                if (view2 != null) {
                    setScrollIndicators(resolvePanel2, view2, z2 | (z3 ? 2 : 0), 3);
                }
            }
            ListView listView2 = this.mListView;
            if (listView2 == null || (listAdapter = this.mAdapter) == null) {
                return;
            }
            listView2.setAdapter(listAdapter);
            int i2 = this.mCheckedItem;
            if (i2 > -1) {
                listView2.setItemChecked(i2, true);
                listView2.setSelection(i2);
            }
        }
    }

    public static boolean shouldCenterSingleButton(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
            return typedValue.data != 0;
        }
        return invokeL.booleanValue;
    }

    public Button getButton(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 != -3) {
                if (i2 != -2) {
                    if (i2 != -1) {
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

    public int getIconAttributeResId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(i2, typedValue, true);
            return typedValue.resourceId;
        }
        return invokeI.intValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mListView : (ListView) invokeV.objValue;
    }

    public void installContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mDialog.setContentView(selectContentView());
            setupView();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            NestedScrollView nestedScrollView = this.mScrollView;
            return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            NestedScrollView nestedScrollView = this.mScrollView;
            return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void setButton(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), charSequence, onClickListener, message, drawable}) == null) {
            if (message == null && onClickListener != null) {
                message = this.mHandler.obtainMessage(i2, onClickListener);
            }
            if (i2 == -3) {
                this.mButtonNeutralText = charSequence;
                this.mButtonNeutralMessage = message;
                this.mButtonNeutralIcon = drawable;
            } else if (i2 == -2) {
                this.mButtonNegativeText = charSequence;
                this.mButtonNegativeMessage = message;
                this.mButtonNegativeIcon = drawable;
            } else if (i2 == -1) {
                this.mButtonPositiveText = charSequence;
                this.mButtonPositiveMessage = message;
                this.mButtonPositiveIcon = drawable;
            } else {
                throw new IllegalArgumentException("Button does not exist");
            }
        }
    }

    public void setButtonPanelLayoutHint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mButtonPanelLayoutHint = i2;
        }
    }

    public void setCustomTitle(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.mCustomTitleView = view;
        }
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mIcon = null;
            this.mIconId = i2;
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                if (i2 != 0) {
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

    public void setView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mView = null;
            this.mViewLayoutResId = i2;
            this.mViewSpacingSpecified = false;
        }
    }

    public void setView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            this.mView = view;
            this.mViewLayoutResId = 0;
            this.mViewSpacingSpecified = false;
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

    public void setView(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mView = view;
            this.mViewLayoutResId = 0;
            this.mViewSpacingSpecified = true;
            this.mViewSpacingLeft = i2;
            this.mViewSpacingTop = i3;
            this.mViewSpacingRight = i4;
            this.mViewSpacingBottom = i5;
        }
    }
}
