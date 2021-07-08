package com.baidu.pass.ecommerce.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SpeechRecognitionDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ELLIPSIS_NORMAL = "…";
    public static final int REQUEST_SETTING_CODE = 9000;
    public static final int STATE_CODE_ALREADY_RESPONSE = 0;
    public static final int STATE_CODE_NOT_RESPONSE = 1;
    public static final int STATE_STOP_SPEECH_LAYOUT_DISABLE = 2;
    public static final int STATE_STOP_SPEECH_LAYOUT_LOADING = 1;
    public static final int STATE_STOP_SPEECH_LAYOUT_NORMAL = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity activity;
    public ImageView closeButton;
    public int currentStateCode;
    public View errorParentView;
    public LoadCircleView loadCircleView;
    public ImageView microphoneImage;
    public ResetCallback resetCallback;
    public RelativeLayout stopSpeechLayout;
    public StopSpeechLister stopSpeechLister;
    public TextView stopSpeechTx;
    public RelativeLayout tipsAreaLayout;
    public TextView tipsTextView;
    public ViewStub viewStub;
    public RelativeLayout voiceParentLayout;
    public VoiceSinWaveView voiceSinWaveView;

    /* loaded from: classes2.dex */
    public interface ResetCallback {
        void onReset();
    }

    /* loaded from: classes2.dex */
    public interface StopSpeechLister {
        void onStopSpeech();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechRecognitionDialog(Activity activity) {
        super(activity, R.style.sapi_sdk_speech_dialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentStateCode = 1;
        this.activity = activity;
    }

    private void ellipsize(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, textView, str) == null) {
            int maxLines = TextViewCompat.getMaxLines(textView);
            int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            if (maxLines < 2) {
                textView.setText(str);
                return;
            }
            List<Point> lineStartAndEnd = getLineStartAndEnd(textView.getPaint(), str, width);
            if (lineStartAndEnd.size() <= maxLines) {
                textView.setText(str);
                return;
            }
            String substring = str.substring(1, lineStartAndEnd.get(0).y);
            String substring2 = str.substring((str.length() - lineStartAndEnd.get(0).y) - 1);
            textView.setText("…" + substring + substring2);
        }
    }

    private List<Point> getLineStartAndEnd(TextPaint textPaint, CharSequence charSequence, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, textPaint, charSequence, i2)) == null) {
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            int lineCount = staticLayout.getLineCount();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < lineCount; i3++) {
                arrayList.add(new Point(staticLayout.getLineStart(i3), staticLayout.getLineEnd(i3)));
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    @Override // android.app.Dialog
    @TargetApi(3)
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            Window window = getWindow();
            window.setGravity(80);
            window.setWindowAnimations(R.style.sapi_sdk_anim_speech);
            setContentView(R.layout.layout_sapi_sdk_dialog_speech_recognition);
            Display defaultDisplay = this.activity.getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = SapiUtils.dip2px(getContext(), 297.0f);
            getWindow().setAttributes(attributes);
            this.tipsTextView = (TextView) findViewById(R.id.tips_tx);
            this.voiceParentLayout = (RelativeLayout) findViewById(R.id.voice_parent_layout);
            this.closeButton = (ImageView) findViewById(R.id.close_button);
            this.stopSpeechLayout = (RelativeLayout) findViewById(R.id.stop_speech_background_layout);
            this.tipsAreaLayout = (RelativeLayout) findViewById(R.id.tips_area_layout);
            this.microphoneImage = (ImageView) findViewById(R.id.microphone_icon);
            this.stopSpeechTx = (TextView) findViewById(R.id.stop_speech_tx);
            VoiceSinWaveView voiceSinWaveView = new VoiceSinWaveView(getContext());
            this.voiceSinWaveView = voiceSinWaveView;
            voiceSinWaveView.showInParentView(this.voiceParentLayout);
            this.voiceSinWaveView.start();
            this.stopSpeechLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SpeechRecognitionDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SpeechRecognitionDialog this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.stopSpeechLister == null) {
                        return;
                    }
                    this.this$0.stopSpeechLister.onStopSpeech();
                }
            });
            this.closeButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SpeechRecognitionDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SpeechRecognitionDialog this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.dismiss();
                    }
                }
            });
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RelativeLayout relativeLayout = this.tipsAreaLayout;
            if (relativeLayout != null && this.voiceParentLayout != null) {
                relativeLayout.setVisibility(0);
                this.voiceParentLayout.setVisibility(0);
                this.voiceParentLayout.removeAllViews();
                VoiceSinWaveView voiceSinWaveView = new VoiceSinWaveView(getContext());
                this.voiceSinWaveView = voiceSinWaveView;
                voiceSinWaveView.showInParentView(this.voiceParentLayout);
                this.voiceSinWaveView.start();
            }
            View view = this.errorParentView;
            if (view != null) {
                view.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.stopSpeechLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SpeechRecognitionDialog.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SpeechRecognitionDialog this$0;

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

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.this$0.stopSpeechLister == null) {
                            return;
                        }
                        this.this$0.stopSpeechLister.onStopSpeech();
                    }
                });
            }
            this.stopSpeechTx.setText(R.string.sapi_sdk_speech_recognition_stop_speech);
            ResetCallback resetCallback = this.resetCallback;
            if (resetCallback != null) {
                resetCallback.onReset();
            }
        }
    }

    public void setActualTimeWord(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (textView = this.tipsTextView) == null) {
            return;
        }
        ellipsize(textView, str);
    }

    public void setResetCallback(ResetCallback resetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, resetCallback) == null) {
            this.resetCallback = resetCallback;
        }
    }

    public void setRippleAmplitude(int i2) {
        VoiceSinWaveView voiceSinWaveView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (voiceSinWaveView = this.voiceSinWaveView) == null) {
            return;
        }
        voiceSinWaveView.changeVolume(i2);
    }

    public void setStopSpeechLayout(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 0) {
                this.stopSpeechLayout.setBackgroundResource(R.drawable.sapi_sdk_stop_speech_layout_rounded_coener);
                this.stopSpeechLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SpeechRecognitionDialog.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SpeechRecognitionDialog this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.reset();
                        }
                    }
                });
                this.stopSpeechTx.setText(R.string.sapi_sdk_speech_recognition_error_interrupt_content);
                this.stopSpeechTx.setVisibility(0);
            } else if (i2 != 1) {
                if (i2 != 2 || (relativeLayout = this.stopSpeechLayout) == null || this.microphoneImage == null || this.stopSpeechTx == null) {
                    return;
                }
                relativeLayout.setClickable(false);
                this.stopSpeechLayout.setBackgroundResource(R.drawable.sapi_sdk_stop_speech_gray_layout_rounded_coener);
                this.stopSpeechTx.setVisibility(8);
            } else {
                RelativeLayout relativeLayout2 = this.stopSpeechLayout;
                if (relativeLayout2 == null || this.stopSpeechTx == null) {
                    return;
                }
                relativeLayout2.setClickable(false);
                this.stopSpeechLayout.setBackgroundResource(R.drawable.sapi_sdk_stop_speech_pressed_layout_rounded_coener);
                this.stopSpeechTx.setText(R.string.sapi_sdk_speech_recognition_is_identifying);
                this.stopSpeechTx.setVisibility(0);
            }
        }
    }

    public void setStopSpeechLister(StopSpeechLister stopSpeechLister) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, stopSpeechLister) == null) {
            this.stopSpeechLister = stopSpeechLister;
        }
    }

    public void showErrorPage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            RelativeLayout relativeLayout = this.tipsAreaLayout;
            if (relativeLayout != null && this.voiceParentLayout != null) {
                relativeLayout.setVisibility(8);
                this.voiceParentLayout.setVisibility(8);
            }
            ViewStub viewStub = (ViewStub) findViewById(R.id.voice_error_parent_view);
            this.viewStub = viewStub;
            View inflate = viewStub != null ? viewStub.inflate() : this.errorParentView;
            this.errorParentView = inflate;
            if (inflate != null) {
                if (4 != inflate.getVisibility()) {
                    this.errorParentView.setVisibility(0);
                }
                ImageView imageView = (ImageView) this.errorParentView.findViewById(R.id.error_icon);
                TextView textView = (TextView) this.errorParentView.findViewById(R.id.error_title);
                TextView textView2 = (TextView) this.errorParentView.findViewById(R.id.error_content);
                TextView textView3 = (TextView) this.errorParentView.findViewById(R.id.error_desc);
                Button button = (Button) this.errorParentView.findViewById(R.id.error_btn);
                button.setVisibility(8);
                textView3.setVisibility(8);
                button.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SpeechRecognitionDialog.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SpeechRecognitionDialog this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, this.this$0.activity.getPackageName(), null));
                            this.this$0.activity.startActivityForResult(intent, 9000);
                        }
                    }
                });
                ((ImageView) this.errorParentView.findViewById(R.id.close_button_stub)).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SpeechRecognitionDialog.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SpeechRecognitionDialog this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.dismiss();
                        }
                    }
                });
                switch (i2) {
                    case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_INTERRUPT /* -506 */:
                        textView.setText(R.string.sapi_sdk_speech_recognition_error_interrupt_title);
                        textView2.setText(R.string.sapi_sdk_speech_recognition_error_interrupt_tips);
                        setStopSpeechLayout(0);
                        setActualTimeWord(getContext().getString(R.string.sapi_sdk_speech_recognition_tips_text));
                        return;
                    case -505:
                        textView.setText(R.string.sapi_sdk_speech_recognition_error_net_time_out_title);
                        textView2.setText(R.string.sapi_sdk_speech_recognition_error_net_time_out_content);
                        break;
                    case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_MICRO_OFF /* -504 */:
                        textView.setText(R.string.sapi_sdk_speech_recognition_error_microphone_title);
                        textView2.setText(R.string.sapi_sdk_speech_recognition_error_microphone_content);
                        button.setVisibility(0);
                        textView3.setVisibility(0);
                        break;
                    case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_NET_OFF /* -503 */:
                        textView.setText(R.string.sapi_sdk_speech_recognition_error_net_off_title);
                        textView2.setText(R.string.sapi_sdk_speech_recognition_error_net_off_content);
                        break;
                    case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_INIT_FAIL /* -502 */:
                        textView.setText(R.string.sapi_sdk_speech_recognition_error_init_fail);
                        textView2.setText(R.string.sapi_sdk_speech_recognition_error_retry);
                        break;
                    default:
                        textView.setText(R.string.sapi_sdk_speech_recognition_error_unkown);
                        textView2.setText(R.string.sapi_sdk_speech_recognition_error_retry);
                        break;
                }
            }
            setStopSpeechLayout(2);
        }
    }

    public void showloadCircleView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.loadCircleView = new LoadCircleView(getContext(), SapiUtils.dip2px(getContext(), 25.0f), -1);
            RelativeLayout relativeLayout = this.voiceParentLayout;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.voiceParentLayout.addView(this.loadCircleView);
                this.loadCircleView.begin();
            }
        }
    }
}
