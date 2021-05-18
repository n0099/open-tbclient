package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.squareup.wire.Wire;
import tbclient.GetUserByTiebaUid.GetUserByTiebaUidResIdl;
/* loaded from: classes3.dex */
public class TiebaUidCheckSocketResMsg extends SocketResponsedMessage {
    public UserData mUserData;

    public TiebaUidCheckSocketResMsg(int i2) {
        super(i2);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        try {
            GetUserByTiebaUidResIdl getUserByTiebaUidResIdl = (GetUserByTiebaUidResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserByTiebaUidResIdl.class);
            if (getUserByTiebaUidResIdl == null || getUserByTiebaUidResIdl.data == null) {
                return;
            }
            UserData userData = new UserData();
            this.mUserData = userData;
            userData.parserProtobuf(getUserByTiebaUidResIdl.data.user);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
