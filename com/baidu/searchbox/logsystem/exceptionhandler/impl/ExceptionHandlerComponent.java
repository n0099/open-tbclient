package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.mf1;
import com.baidu.tieba.of1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public of1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        mf1 b = mf1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
